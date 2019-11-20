package org.gaborbalazs.smartplatform.edgeservice.integrationtest.test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.gaborbalazs.smartplatform.edgeservice.application.EdgeServiceApplication;
import org.gaborbalazs.smartplatform.edgeservice.integrationtest.framework.WireMockService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EdgeServiceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
class TestBase {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WireMockService wireMockService;

    @BeforeEach
    void setUp() {
        wireMockService.start();
    }

    @AfterEach
    void tearDown() {
        wireMockService.stop();
    }

    DocumentContext getResponseAsJsonParser(MvcResult mvcResult) {
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
