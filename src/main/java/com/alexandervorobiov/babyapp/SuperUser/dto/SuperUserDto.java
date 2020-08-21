package com.alexandervorobiov.babyapp.SuperUser.dto;

import com.alexandervorobiov.babyapp.Child.Child;
import com.alexandervorobiov.babyapp.Child.ChildDetailsDto;
import com.alexandervorobiov.babyapp.Child.ChildRegistrationDto;
import com.alexandervorobiov.babyapp.Child.hint.Hint;
import com.alexandervorobiov.babyapp.Child.hint.HintDto;
import com.alexandervorobiov.babyapp.Child.tip.FoodTip;
import com.alexandervorobiov.babyapp.Child.tip.FoodTipDto;
import com.alexandervorobiov.babyapp.SuperUser.FoodTypeEnum.FoodType;
import com.alexandervorobiov.babyapp.SuperUser.GenderEnum.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.print.attribute.standard.MediaSize;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class SuperUserDto {

    private Long id;
//    @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$", message = "Nazwa powinna zawierać 8-20 znaków a-z, A-Z, 0-9")
//    @NotBlank
//    @NotNull
    @JsonProperty("parentName") // nazwa na froncie
    private String name; //parentnme

//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message = "Hasło powinno zawierać 8-20 znaków małą literę, dużą literę i cyfrę")
    private String password;

//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message = "Hasło powinno zawierać 8-20 znaków małą literę, dużą literę i cyfrę")
//    private String confirmPassword;
//    @Email
//    @NotBlank
//    @NotNull
//    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "Nie własciwy email")
    private String email;
    private String telephone;
    @JsonFormat(pattern="MM/dd/yyyy ")
    private String creationDateTime;


//    private List<FoodTip> tips;
//    private List<Hint> hint;
    private Set<ChildDetailsDto> children = new HashSet<>();


////    @NotBlank
////    @NotNull
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message = "Hasło powinno zawierać 8-20 znaków małą literę, dużą literę i cyfrę")
//    private String childName;
////    @NotBlank
////    @NotNull
//    @JsonFormat(pattern="MM/dd/yyyy")
//    private LocalDate childBirthDay;
////    @NotBlank
////    @NotNull
//    @Enumerated(value = EnumType.STRING)
//    private Gender gender;
////    @NotBlank
////    @NotNull
//    //regexp
//    private double weight;
////    @NotBlank
////    @NotNull
//    //regexp
//    private double growth;
////    @NotBlank
////    @NotNull
//    @Enumerated(value = EnumType.STRING)
//    private FoodType foodType;


}
