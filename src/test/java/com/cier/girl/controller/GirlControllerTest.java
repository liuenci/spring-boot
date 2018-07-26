package com.cier.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * API 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getGirlList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("[{\"id\":1,\"cupSize\":\"E\",\"age\":14},{\"id\":3,\"cupSize\":\"C\",\"age\":14},{\"id\":4,\"cupSize\":\"A\",\"age\":18},{\"id\":5,\"cupSize\":\"B\",\"age\":17},{\"id\":6,\"cupSize\":\"A\",\"age\":18},{\"id\":8,\"cupSize\":\"C\",\"age\":14},{\"id\":9,\"cupSize\":\"C\",\"age\":20},{\"id\":10,\"cupSize\":\"B\",\"age\":10}]"));
    }
}