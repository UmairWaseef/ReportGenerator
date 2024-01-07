package com.reportgenerator.nutrition_report.service;

import com.reportgenerator.nutrition_report.Entity.Nutrient;
import com.reportgenerator.nutrition_report.repository.NutrientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutrientServiceImpl implements NutrientService {
    @Autowired
    NutrientRepository nutrientRepository;

    @Override
    public Nutrient saveNutrient(Nutrient nutrient) {
        return nutrientRepository.save(nutrient);
    }

    @Override
    public List<Nutrient> getAllNutrients() {
        return nutrientRepository.findAll();
    }

    @Override
    public List<Nutrient> findByUserUserId(Long userId) {
        return nutrientRepository.findByUser_UserId(userId);  // Adjust the method call
    }
}
