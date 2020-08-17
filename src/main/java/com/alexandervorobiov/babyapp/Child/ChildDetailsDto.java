package com.alexandervorobiov.babyapp.Child;

import com.alexandervorobiov.babyapp.Child.hint.HintDto;
import com.alexandervorobiov.babyapp.Child.tip.FoodTipDto;
import com.alexandervorobiov.babyapp.SuperUser.FoodTypeEnum.FoodType;
import com.alexandervorobiov.babyapp.SuperUser.GenderEnum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildDetailsDto {

    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    private Double weight;
    private Double growth;
    private FoodType foodType;
    private List<FoodTipDto> tips = new ArrayList<>(); //tips dto
    private List<HintDto> hint = new ArrayList<>(); // hint dto


}
