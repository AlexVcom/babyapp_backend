package com.alexandervorobiov.babyapp.Child.hint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HintRepository extends JpaRepository<Hint, Long> {
//  @Query("select h from Hint h where h.startAge >= ?1 and h.endAge <= ?1")
    @Query(value = "select * from hint h where h.start_age >= ?1 and h.end_age <= ?1", nativeQuery = true)
    List<Hint> findForHints(Integer age);
}
