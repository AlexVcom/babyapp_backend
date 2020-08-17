package com.alexandervorobiov.babyapp.Child;

import com.alexandervorobiov.babyapp.SuperUser.FoodTypeEnum.FoodType;
import com.alexandervorobiov.babyapp.SuperUser.GenderEnum.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildRegistrationDto {

    private String name;
    @JsonFormat(pattern="MM/dd/yyyy")
    private LocalDate birthDate;
    private Gender gender;
    private Double weight;
    private Double growth;
    private FoodType foodType;
}
