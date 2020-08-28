package com.alexandervorobiov.babyapp.SuperUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SuperUserRepo extends JpaRepository<SuperUser, Long> {
    Optional<SuperUser> findByName(String superUser);
//    List<SuperUser> findAllByUserId(Long id);
}
