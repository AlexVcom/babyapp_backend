package com.alexandervorobiov.babyapp.superUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SuperUserRepository extends JpaRepository<SuperUser, Long> {
    Optional<SuperUser> findByName(String superUser);
}
