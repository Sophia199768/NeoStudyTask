package com.example.neostudytask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class NeoStudyTaskApplicationTests {
    @Autowired
    private  MockMvc api;

    @Test
    void calculateTest() throws Exception {

        MvcResult result = api.perform(MockMvcRequestBuilders.get("/calculate")
                        .param("averageSalary", "20000")
                        .param("amountOfHolidays", "10")
                        .param("startMonth", "7")
                        .param("startDay", "7")
                        .param("year", "2024"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertEquals(result.getAsyncResult(), 7 * 20000 / 29.3);
    }
}
