package com.reportgenerator.nutrition_report.controller;

import com.reportgenerator.nutrition_report.Entity.Nutrient;
import com.reportgenerator.nutrition_report.service.NutrientService;
import com.reportgenerator.nutrition_report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutrients")
public class NutrientController {
    @Autowired
    private NutrientService nutrientService;

    @PostMapping("/addNutrients")
    public Nutrient addNutrients(@RequestBody Nutrient nutrient){
        return nutrientService.saveNutrient(nutrient);
    }

    @GetMapping("/allNutrients")
    public List<Nutrient> getAllNutrients(){
        return nutrientService.getAllNutrients();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Nutrient>> getNutrientsByUserId(@PathVariable Long userId) {
        List<Nutrient> nutrients = nutrientService.findByUserUserId(userId);
        return new ResponseEntity<>(nutrients, HttpStatus.OK);
    }
}
