package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Meal;
import io.swagger.repository.MealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

@Controller
public class MealsApiController implements MealsApi {

    private static final Logger log = LoggerFactory.getLogger(MealsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    public MealsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<LinkedHashMap<LocalDate, Integer>> listDatesWithMeals() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Meal> meals = mealRepository.findAllMealsByMealDateIsNotNullAndMealDateGreaterThanOrderByMealDateDesc(LocalDate.now());
            LinkedHashMap<LocalDate, Integer> result = squashMealDatesByCalorieCount(meals);
            return new ResponseEntity<LinkedHashMap<LocalDate, Integer>>(result, HttpStatus.OK);
        }

        return new ResponseEntity<LinkedHashMap<LocalDate, Integer>>(HttpStatus.NOT_IMPLEMENTED);
    }

    private LinkedHashMap<LocalDate, Integer> squashMealDatesByCalorieCount(List<Meal> mealList) {
        LinkedHashMap<LocalDate, Integer> result = new LinkedHashMap<LocalDate, Integer>();

        for (Meal meal : mealList) {

            LocalDate mealDate = meal.getMealDate();
            int calorieCount = meal.getNumberOfCalories();

            if(result.containsKey(mealDate)) {
                calorieCount += result.get(mealDate);
            }
            result.put(mealDate, calorieCount);
        }

        return result;
    }
}
