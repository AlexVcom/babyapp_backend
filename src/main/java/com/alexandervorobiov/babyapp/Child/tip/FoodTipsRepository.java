package com.alexandervorobiov.babyapp.Child.tip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodTipsRepository extends JpaRepository<FoodTip, Long> {

    @Query("select t from FoodTip t where t.startAge >= ?1 and t.endAge <= ?1")
//    @Query(value = "select * from food_tip t where t.start_age >= ?1 and t.end_age <= ?1", nativeQuery = true)
    List<FoodTip> findForTips(Integer age);
}
