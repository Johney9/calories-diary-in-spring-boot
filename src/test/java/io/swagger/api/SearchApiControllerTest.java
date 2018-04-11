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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Swagger2SpringBoot.class)
@AutoConfigureMockMvc
public class SearchApiControllerTest {

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
        meal = new Meal(LocalDate.parse("2019-07-16"), LocalTime.parse("13:46"), "banana", 350);
        mealRepository.save(meal);
    }

    @Test
    public void searchExisting() throws Exception {
        String description = "celer";
        mockMvc.perform(get("/search?description=" + description)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].mealDescription", is(description)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void searchExistingWithMultipleResults() throws Exception {
        String description = "banana";
        mockMvc.perform(get("/search?description=" + description)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].mealDescription", is(description)))
                .andExpect(jsonPath("$[1].mealDescription", is(description)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void searchNonExisting() throws Exception {
        String description = "jagoda";
        mockMvc.perform(get("/search?description=" + description)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json"))
                .andExpect(status().isNotFound());
    }
}