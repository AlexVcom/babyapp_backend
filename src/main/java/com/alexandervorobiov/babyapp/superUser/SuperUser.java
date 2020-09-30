package com.alexandervorobiov.babyapp.superUser;

import com.alexandervorobiov.babyapp.child.Child;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "super_user")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
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
    @OneToMany(cascade = CascadeType.ALL)
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
