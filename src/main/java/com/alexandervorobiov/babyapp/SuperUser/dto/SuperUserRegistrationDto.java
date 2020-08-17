package com.alexandervorobiov.babyapp.SuperUser.dto;


import com.alexandervorobiov.babyapp.Child.ChildRegistrationDto;
import com.alexandervorobiov.babyapp.Child.hint.HintDto;
import com.alexandervorobiov.babyapp.Child.tip.FoodTipDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
public class SuperUserRegistrationDto {

    private Long id;
    //    @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$", message = "Nazwa powinna zawierać 8-20 znaków a-z, A-Z, 0-9")
//    @NotBlank
//    @NotNull
    @JsonProperty("parentName") // nazwa na froncie
    private String name; //parentnme
    //    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message = "Hasło powinno zawierać 8-20 znaków małą literę, dużą literę i cyfrę")
    private String password;
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message = "Hasło powinno zawierać 8-20 znaków małą literę, dużą literę i cyfrę")
//    private String confirmPassword;
//    @Email
//    @NotBlank
//    @NotNull
//    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "Nie własciwy email")
    private String email;
    private String telephone;

    private List<ChildRegistrationDto> children;

}
