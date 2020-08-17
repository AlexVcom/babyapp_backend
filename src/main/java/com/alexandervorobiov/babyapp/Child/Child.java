package com.alexandervorobiov.babyapp.Child;

import com.alexandervorobiov.babyapp.SuperUser.FoodTypeEnum.FoodType;
import com.alexandervorobiov.babyapp.SuperUser.GenderEnum.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    @JsonFormat(pattern="MM/dd/yyyy")
    private LocalDate birthDate;
    private Gender gender;
    private Double weight;
    private Double growth;
    private FoodType foodType;

    public Integer getAge() {
        return Period.between(birthDate, LocalDate.now()).getDays();
    }



}
