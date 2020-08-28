package com.alexandervorobiov.babyapp.SuperUser;

import com.alexandervorobiov.babyapp.Child.Child;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "super_user")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SuperUser {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private String telephone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "super_user_id")
    private Set<Child> children;

    private LocalDateTime creationDateTime;

    @PrePersist
    public void prePersist() {
        creationDateTime = LocalDateTime.now();
    }

    private LocalDateTime updateDateTime;
    @PreUpdate
    public void preUpdate()
    {
        updateDateTime = LocalDateTime.now();
    }

}
