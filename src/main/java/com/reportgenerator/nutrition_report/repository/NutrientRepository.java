package com.reportgenerator.nutrition_report.repository;

import com.reportgenerator.nutrition_report.Entity.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutrientRepository extends JpaRepository<Nutrient, Long> {
    List<Nutrient> findByUser_UserId(Long userId);
}
