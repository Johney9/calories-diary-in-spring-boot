package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Meal;
import io.swagger.repository.MealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;

@Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

@Controller
public class CreateMealApiController implements CreateMealApi {

    private static final Logger log = LoggerFactory.getLogger(CreateMealApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    public CreateMealApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Meal> createMeal(@ApiParam(value = "Date of meal", required = true) @RequestParam(value = "mealDate", required = true) @DateTimeFormat(pattern = "YYYY-MM-DD") String mealDate,
                                           @ApiParam(value = "Time of meal", required = true) @RequestParam(value = "mealTime", required = true) @DateTimeFormat(pattern = "HH:MM:SS") String mealTime,
                                           @ApiParam(value = "Number of calories of the meal", required = true) @RequestParam(value = "numberOfCalories", required = true) Integer numberOfCalories,
                                           @ApiParam(value = "Description of the meal") @RequestParam(value = "mealDescription", required = false) String mealDescription) {

        String accept = request.getHeader("Accept");

        if(accept != null && accept.contains("application/json")) {
            Meal meal = new Meal();
            meal.setMealDate(LocalDate.parse(mealDate));
            meal.setMealTime(LocalTime.parse(mealTime));
            meal.setMealDescription(mealDescription);
            meal.setNumberOfCalories(numberOfCalories);
            meal = mealRepository.save(meal);

            return new ResponseEntity<Meal>(meal, HttpStatus.CREATED);
        }

        return new ResponseEntity<Meal>(HttpStatus.BAD_REQUEST);
    }

}
