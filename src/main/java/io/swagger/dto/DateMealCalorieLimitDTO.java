package io.swagger.dto;

import java.time.LocalDate;

public class DateMealCalorieLimitDTO {
    public LocalDate mealDate;
    public int totalCalorieCountForDay;
    public boolean isCalorieSumOverCalorieLimit;

    public DateMealCalorieLimitDTO(LocalDate mealDate, int totalCalorieCountForDay, boolean isCalorieSumOverCalorieLimit) {
        this.mealDate = mealDate;
        this.totalCalorieCountForDay = totalCalorieCountForDay;
        this.isCalorieSumOverCalorieLimit = isCalorieSumOverCalorieLimit;
    }

    public DateMealCalorieLimitDTO() {
    }
}
