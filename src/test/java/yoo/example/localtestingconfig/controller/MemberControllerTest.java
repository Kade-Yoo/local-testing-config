package yoo.example.localtestingconfig.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import yoo.example.localtestingconfig.IntegrationTests;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberControllerTest extends IntegrationTests {

    @Test
    void getMember() throws Exception {
        // given
        long id = 2L;

        // when - then
        MockHttpServletRequestBuilder rq =
                MockMvcRequestBuilders.get("/local-test-config/user/" + id)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(rq).andDo(log()).andExpect(status().isOk())
                .andExpect(jsonPath("$..['memberName']", hasSize(greaterThanOrEqualTo(1))));
    }
}