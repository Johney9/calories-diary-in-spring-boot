package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

@Controller
public class SearchApiController implements SearchApi {

    private static final Logger log = LoggerFactory.getLogger(SearchApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SearchApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Meal>> search(@ApiParam(value = "description value to be searched") @Valid @RequestParam(value = "description", required = false) String description) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Meal>>(objectMapper.readValue("[ {  \"mealTime\" : \"1162\",  \"numberOfCalories\" : 0,  \"mealDescription\" : \"mealDescription\",  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",  \"mealDate\" : \"2018-02-13T00:00:00.000Z\"}, {  \"mealTime\" : \"1162\",  \"numberOfCalories\" : 0,  \"mealDescription\" : \"mealDescription\",  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",  \"mealDate\" : \"2018-02-13T00:00:00.000Z\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Meal>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Meal>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
