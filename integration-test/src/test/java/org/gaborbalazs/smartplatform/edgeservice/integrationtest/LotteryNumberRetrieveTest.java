package org.gaborbalazs.smartplatform.edgeservice.integrationtest;

import org.gaborbalazs.smartplatform.edgeservice.application.EdgeServiceApplication;
import org.gaborbalazs.smartplatform.edgeservice.common.enums.LotteryType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EdgeServiceApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
class LotteryNumberRetrieveTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRetrieveRandom() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/retrieve/lottery/" + LotteryType.FIVE_OUT_OF_NINETY.getPathVariableName() + "/numbers/random").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
