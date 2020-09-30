package com.alexandervorobiov.babyapp.child;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildRepository extends JpaRepository<Child, Long> {
    Optional<Child> findByName(String superUser);
}
