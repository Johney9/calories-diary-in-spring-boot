/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.12).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Meal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalTime;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

@Api(value = "create-meal", description = "the create-meal API")
public interface CreateMealApi {

    @ApiOperation(value = "creates a meal", nickname = "createMeal", notes = "By passing in a Date, Time, Description (optional) and Number of calories,  you can create a meal entry in your diary. ", tags = {"developers",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "meal created"),
            @ApiResponse(code = 400, message = "invalid input, parameters invalid")})
    @RequestMapping(value = "/create-meal",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Meal> createMeal(@ApiParam(value = "Date of meal", required = true) @RequestHeader(value = "mealDate", required = true) @DateTimeFormat(pattern = "YYYY-MM-DD") String mealDate,
                                    @ApiParam(value = "Time of meal", required = true) @RequestHeader(value = "mealTime", required = true) @DateTimeFormat(pattern = "HH:MM:SS") String mealTime,
                                    @ApiParam(value = "Number of calories of the meal", required = true) @RequestHeader(value = "numberOfCalories", required = true) Integer numberOfCalories,
                                    @ApiParam(value = "Description of the meal") @RequestHeader(value = "mealDescription", required = false) String mealDescription);

}
