package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

/**
 * Meal
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-06T09:36:55.180Z")

public class Meal {
    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("mealDate")
    private LocalDate mealDate = null;

    @JsonProperty("mealTime")
    private LocalTime mealTime = null;

    @JsonProperty("mealDescription")
    private String mealDescription = null;

    @JsonProperty("numberOfCalories")
    private Integer numberOfCalories = null;

    public Meal id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", value = "")

    @Valid

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Meal mealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
        return this;
    }

    /**
     * Get mealDate
     *
     * @return mealDate
     **/
    @ApiModelProperty(example = "2018-02-13T00:00:00.000Z", required = true, value = "")
    @NotNull

    @Valid

    public LocalDate getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    public Meal mealTime(LocalTime mealTime) {
        this.mealTime = mealTime;
        return this;
    }

    /**
     * Get mealTime
     *
     * @return mealTime
     **/
    @ApiModelProperty(example = "1162", required = true, value = "")
    @NotNull


    public LocalTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(LocalTime mealTime) {
        this.mealTime = mealTime;
    }

    public Meal mealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
        return this;
    }

    /**
     * Get mealDescription
     *
     * @return mealDescription
     **/
    @ApiModelProperty(value = "")


    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public Meal numberOfCalories(Integer numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
        return this;
    }

    /**
     * Get numberOfCalories
     *
     * @return numberOfCalories
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public Integer getNumberOfCalories() {
        return numberOfCalories;
    }

    public void setNumberOfCalories(Integer numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Meal meal = (Meal) o;
        return Objects.equals(this.id, meal.id) &&
                Objects.equals(this.mealDate, meal.mealDate) &&
                Objects.equals(this.mealTime, meal.mealTime) &&
                Objects.equals(this.mealDescription, meal.mealDescription) &&
                Objects.equals(this.numberOfCalories, meal.numberOfCalories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mealDate, mealTime, mealDescription, numberOfCalories);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Meal {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    mealDate: ").append(toIndentedString(mealDate)).append("\n");
        sb.append("    mealTime: ").append(toIndentedString(mealTime)).append("\n");
        sb.append("    mealDescription: ").append(toIndentedString(mealDescription)).append("\n");
        sb.append("    numberOfCalories: ").append(toIndentedString(numberOfCalories)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

