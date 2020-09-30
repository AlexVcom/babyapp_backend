package com.alexandervorobiov.babyapp.child.tip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodTipsRepository extends JpaRepository<FoodTip, Long> {
    @Query("select t from FoodTip t where t.startAge >= ?1 and t.endAge <= ?1")
    List<FoodTip> findForTips(Integer age);
}
