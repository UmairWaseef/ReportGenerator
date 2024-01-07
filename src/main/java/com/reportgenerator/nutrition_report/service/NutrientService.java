package com.reportgenerator.nutrition_report.service;

import com.reportgenerator.nutrition_report.Entity.Nutrient;

import java.util.List;

public interface NutrientService {
    Nutrient saveNutrient(Nutrient nutrient);
    List<Nutrient> getAllNutrients();
    List<Nutrient> findByUserUserId(Long userId);  // Adjust the method name
}
