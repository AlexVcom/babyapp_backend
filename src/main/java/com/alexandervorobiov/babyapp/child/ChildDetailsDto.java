package com.alexandervorobiov.babyapp.child;

import com.alexandervorobiov.babyapp.child.hint.HintDto;
import com.alexandervorobiov.babyapp.child.tip.FoodTipDto;
import com.alexandervorobiov.babyapp.superUser.FoodType;
import com.alexandervorobiov.babyapp.superUser.Gender;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
public class ChildDetailsDto {

    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    private Double weight;
    private Double growth;
    private FoodType foodType;
    private String birthDate;
    private final List<FoodTipDto> tips = new ArrayList<>();
    private final List<HintDto> hint = new ArrayList<>();


}
