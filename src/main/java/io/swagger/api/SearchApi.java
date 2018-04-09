/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.12).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

@Api(value = "search", description = "the search API")
public interface SearchApi {

    @ApiOperation(value = "searches meals based on description", nickname = "search", notes = "By passing in a description, the service will return every meal that has such a description", response = Meal.class, responseContainer = "List", tags = {"developers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "results matching criteria", response = Meal.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Invalid description value")})
    @RequestMapping(value = "/search",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Meal>> search(@ApiParam(value = "description value to be searched") @Valid @RequestParam(value = "description", required = false) String description);

}