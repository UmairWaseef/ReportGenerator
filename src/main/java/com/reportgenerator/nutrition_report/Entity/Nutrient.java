package com.reportgenerator.nutrition_report.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long nutrientId;
    private String nutritionName;
    private int total;
    private int goal;
    private String metric;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
