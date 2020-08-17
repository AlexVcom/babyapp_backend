package com.alexandervorobiov.babyapp.Admin.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@Component
public class LoginAdminDto {

    @NotBlank
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$", message = "Nazwa powinna zawierać 8-20 znaków a-z, A-Z, 0-9")
    private String name;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message = "Hasło powinno zawierać 8-20 znaków małą literę, dużą literę i cyfrę")
    private String password;


}
