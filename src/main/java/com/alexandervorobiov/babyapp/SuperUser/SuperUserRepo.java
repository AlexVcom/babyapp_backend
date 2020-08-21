package com.alexandervorobiov.babyapp.SuperUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface SuperUserRepo extends JpaRepository<SuperUser, Long> {
    Optional<SuperUser> findByName(String superUser);
}
