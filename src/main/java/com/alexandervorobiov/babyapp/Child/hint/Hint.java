package com.alexandervorobiov.babyapp.Child.hint;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Hint { // dto

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String description;

    private Integer startAge;

    private Integer endAge;

}
