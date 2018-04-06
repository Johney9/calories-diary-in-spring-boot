package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;

@Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

@Controller
public class CreateMealApiController implements CreateMealApi {

    private static final Logger log = LoggerFactory.getLogger(CreateMealApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public CreateMealApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createMeal(@ApiParam(value = "Date of meal", required = true) @RequestHeader(value = "mealDate", required = true) LocalDate mealDate, @ApiParam(value = "Time of meal", required = true) @RequestHeader(value = "mealTime", required = true) LocalTime mealTime, @ApiParam(value = "Number of calories of the meal", required = true) @RequestHeader(value = "numberOfCalories", required = true) Integer numberOfCalories, @ApiParam(value = "Description of the meal") @RequestHeader(value = "mealDescription", required = false) String mealDescription) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
