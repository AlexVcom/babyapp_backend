package com.alexandervorobiov.babyapp.Admin;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@Setter
@Getter
public class Admin {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;




}
