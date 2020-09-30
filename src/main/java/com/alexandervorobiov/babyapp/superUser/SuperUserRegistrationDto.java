package com.alexandervorobiov.babyapp.superUser;


import com.alexandervorobiov.babyapp.child.ChildRegistrationDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
public class SuperUserRegistrationDto {

    private Long id;
    @JsonProperty("parentName")
    private String name;
    private String password;
    private String email;
    private String telephone;
    private final List<ChildRegistrationDto> children;
}
