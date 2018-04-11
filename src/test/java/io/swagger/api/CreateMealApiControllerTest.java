package io.swagger.api;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.Meal;
import io.swagger.repository.MealRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Swagger2SpringBoot.class)
@AutoConfigureMockMvc
public class CreateMealApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MealRepository mealRepository;

    @Before
    public void setup() {
        mealRepository.deleteAll();
    }

    @Test
    public void createMealOk() throws Exception {
        mockMvc.perform(post("/create-meal")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .param("mealDate", "2019-04-15")
                .param("mealTime", "09:00")
                .param("description", "mrkva")
                .param("numberOfCalories", "40")).andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void createMealNoHeader() throws Exception {
        mockMvc.perform(post("/create-meal")
                .param("mealDate", "2019-04-15")
                .param("mealTime", "09:00")
                .param("description", "mrkva")
                .param("numberOfCalories", "40")).andExpect(status().isBadRequest());
    }
}