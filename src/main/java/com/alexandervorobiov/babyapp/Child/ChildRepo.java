package com.alexandervorobiov.babyapp.Child;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildRepo  extends JpaRepository<Child, Long> {
    Optional<Child> findByName(String superUser);
}
