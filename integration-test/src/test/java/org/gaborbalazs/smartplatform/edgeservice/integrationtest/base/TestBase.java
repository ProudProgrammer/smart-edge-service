package org.gaborbalazs.smartplatform.edgeservice.integrationtest.base;

import org.gaborbalazs.smartplatform.edgeservice.application.EdgeServiceApplication;
import org.gaborbalazs.smartplatform.edgeservice.integrationtest.component.DocumentContextFactory;
import org.gaborbalazs.smartplatform.edgeservice.integrationtest.component.WireMockService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EdgeServiceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
public class TestBase {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected DocumentContextFactory documentContextFactory;

    @Autowired
    private WireMockService wireMockService;

    @BeforeEach
    void setUp() {
        wireMockService.start();
    }

    @AfterEach
    void tearDown() {
        wireMockService.stop();
    }
}
