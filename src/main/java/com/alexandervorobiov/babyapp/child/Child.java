package com.alexandervorobiov.babyapp.child;

import com.alexandervorobiov.babyapp.superUser.FoodType;
import com.alexandervorobiov.babyapp.superUser.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Builder
@AllArgsConstructor
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
