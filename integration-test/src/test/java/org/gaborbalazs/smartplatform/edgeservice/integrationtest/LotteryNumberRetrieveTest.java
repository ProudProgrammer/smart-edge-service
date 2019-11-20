package org.gaborbalazs.smartplatform.edgeservice.integrationtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class LotteryNumberRetrieveTest extends LotteryNumberRetrieveTestBase {

    @Test
    void testRetrieveRandom() throws Exception {
        // GIVEN

        // WHEN
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(EDGE_SERVICE_LOTTERY_NUMBER_RETRIEVE_FIVE_OUT_OF_NINETY_ENDPOINT);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        // THEN
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
}
