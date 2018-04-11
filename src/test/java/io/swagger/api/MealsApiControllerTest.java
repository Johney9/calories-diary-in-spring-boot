package io.swagger.api;

import io.swagger.Swagger2SpringBoot;
import io.swagger.constants.MealConstants;
import io.swagger.model.Meal;
import io.swagger.repository.MealRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Swagger2SpringBoot.class)
@AutoConfigureMockMvc
public class MealsApiControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Meal meal = null;

    @Autowired
    private MealRepository mealRepository;


    @Before
    public void setup() {
        mealRepository.deleteAll();
        meal = new Meal(LocalDate.parse("2018-04-30"), LocalTime.parse("09:00"), "mrkva", 40);
        mealRepository.save(meal);
        meal = new Meal(LocalDate.parse("2018-04-30"), LocalTime.parse("13:00"), "chipotle burrito", 1200);
        mealRepository.save(meal);
        meal = new Meal(LocalDate.parse("2017-04-15"), LocalTime.parse("09:21"), "celer", 120);
        mealRepository.save(meal);
        meal = new Meal(LocalDate.parse("2019-05-15"), LocalTime.parse("10:00"), "avokado", 320);
        mealRepository.save(meal);
        meal = new Meal(LocalDate.parse("2019-06-16"), LocalTime.parse("11:37"), "banana", 350);
        mealRepository.save(meal);
    }

    @Test
    public void listDatesWithMealsOk() throws Exception {

        System.out.println("Test running assuming fixed calorie limit of: " + 500);
        //get future meal dates
        mockMvc.perform(get("/meals")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].mealDate", is("2019-06-16")))
                .andExpect(jsonPath("$[2].mealDate", is("2018-04-30")))
                .andExpect(jsonPath("$[2].totalCalorieCountForDay", is(1240)))
                .andExpect(jsonPath("$[2].isCalorieSumOverCalorieLimit", is(true)))
                .andExpect(jsonPath("$[1].totalCalorieCountForDay", is(320)))
                .andExpect(jsonPath("$[1].isCalorieSumOverCalorieLimit", is(false)))
                .andDo(MockMvcResultHandlers.print());
    }
}