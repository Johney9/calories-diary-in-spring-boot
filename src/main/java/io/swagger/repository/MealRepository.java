package io.swagger.repository;

import io.swagger.model.Meal;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Long> {

    List<Meal> findAllMealsByMealDescriptionAndMealDateGreaterThan(String mealDescription, LocalDate today);
    List<Meal> findAllMealsByMealDateIsNotNullAndMealDateGreaterThanOrderByMealDateDesc(LocalDate today);

}
