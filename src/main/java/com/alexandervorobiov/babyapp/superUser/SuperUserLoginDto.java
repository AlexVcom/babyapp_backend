package com.alexandervorobiov.babyapp.superUser;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
public class SuperUserLoginDto {

    @NotBlank
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$", message = "Nazwa powinna zawierać 8-20 znaków a-z, A-Z, 0-9")
    private String name;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message = "Hasło powinno zawierać 8-20 znaków małą literę, dużą literę i cyfrę")
    private String Password;


}
