package com.alexandervorobiov.babyapp.child.hint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HintRepository extends JpaRepository<Hint, Long> {
  @Query("select h from Hint h where h.startAge >= ?1 and h.endAge <= ?1")
    List<Hint> findForHints(Integer age);
}
