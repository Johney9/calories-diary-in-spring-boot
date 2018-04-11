package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Meal;
import io.swagger.repository.MealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

@Controller
public class SearchApiController implements SearchApi {

    private static final Logger log = LoggerFactory.getLogger(SearchApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    public SearchApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Meal>> search(@ApiParam(value = "description value to be searched") @Valid @RequestParam(value = "description", required = false) String description) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            List<Meal> mealList = mealRepository.findAllMealsByMealDescription(description);
            if (mealList.isEmpty())
                return new ResponseEntity<List<Meal>>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<List<Meal>>(mealList, HttpStatus.OK);
        }

        return new ResponseEntity<List<Meal>>(HttpStatus.BAD_REQUEST);
    }

}
