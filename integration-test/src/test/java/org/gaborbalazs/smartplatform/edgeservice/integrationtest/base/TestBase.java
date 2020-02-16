package org.gaborbalazs.smartplatform.edgeservice.integrationtest.base;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.gaborbalazs.smartplatform.edgeservice.application.EdgeServiceApplication;
import org.gaborbalazs.smartplatform.edgeservice.integrationtest.framework.JsonResourceProvider;
import org.gaborbalazs.smartplatform.edgeservice.integrationtest.framework.WireMockService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EdgeServiceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
public class TestBase {

    private static final String BASE_RESOURCE_PATH = "response/mock/";

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WireMockService wireMockService;

    @Autowired
    private JsonResourceProvider jsonResourceProvider;

    @BeforeEach
    void setUp() {
        wireMockService.start();
    }

    @AfterEach
    void tearDown() {
        wireMockService.stop();
    }

    protected void setUpStub(String url, String responseFilePath, HttpStatus httpStatus, Map<String, String> headers) {
        ResponseDefinitionBuilder responseDefinitionBuilder = WireMock.aResponse()
                .withStatus(httpStatus.value())
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .withBody(jsonResourceProvider.getJsonContent(BASE_RESOURCE_PATH + responseFilePath));
        headers.forEach(responseDefinitionBuilder::withHeader);
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url)).willReturn(responseDefinitionBuilder));
    }

    protected DocumentContext getResponseAsJsonParser(MvcResult mvcResult) {
        MockHttpServletResponse response = mvcResult.getResponse();
        Assertions.assertNotNull(response);
        String content = null;
        try {
            content = response.getContentAsString();
        } catch (UnsupportedEncodingException e) {
            Assertions.fail("Encoding not supported.");
        }
        Assertions.assertNotNull(content);
        return JsonPath
                .using(Configuration
                        .defaultConfiguration()
                        .addOptions(Option.SUPPRESS_EXCEPTIONS)
                        .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL))
                .parse(content);
    }
}
