package com.alexandervorobiov.babyapp.admin;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "admin")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;




}
