/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.12).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.threeten.bp.LocalDate;

import javax.annotation.Generated;
import java.util.List;

@Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

@Api(value = "meals", description = "the meals API")
public interface MealsApi {

    @ApiOperation(value = "lists all dates that have meals", nickname = "listDatesWithMeals", notes = "bla bla bla, violent torrent ", response = LocalDate.class, responseContainer = "List", tags = {"developers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "results matching criteria", response = LocalDate.class, responseContainer = "List")})
    @RequestMapping(value = "/meals",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<LocalDate>> listDatesWithMeals();

}
