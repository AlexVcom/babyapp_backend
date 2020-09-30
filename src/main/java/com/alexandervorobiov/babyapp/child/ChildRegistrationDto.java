package com.alexandervorobiov.babyapp.child;

import com.alexandervorobiov.babyapp.superUser.FoodType;
import com.alexandervorobiov.babyapp.superUser.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
public class ChildRegistrationDto {

    private String name;
    @JsonFormat(pattern="MM/dd/yyyy")
    private LocalDate birthDate;
    private Gender gender;
    private Double weight;
    private Double growth;
    private FoodType foodType;
}
