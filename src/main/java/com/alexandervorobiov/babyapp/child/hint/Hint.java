package com.alexandervorobiov.babyapp.child.hint;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@NoArgsConstructor
public class Hint {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String description;
    private Integer startAge;
    private Integer endAge;

}
