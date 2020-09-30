package com.alexandervorobiov.babyapp.superUser;

import com.alexandervorobiov.babyapp.child.ChildDetailsDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
public class SuperUserDto {

    private Long id;
    @JsonProperty("parentName") // nazwa na froncie
    private String name;
    private String password;
    private String email;
    private String telephone;
    private LocalDateTime creationDateTime;
    private final Set<ChildDetailsDto> children = new HashSet<>();

}
