package com.reportgenerator.nutrition_report.service;

import com.reportgenerator.nutrition_report.Entity.Nutrient;
import com.reportgenerator.nutrition_report.Entity.User;
import com.reportgenerator.nutrition_report.repository.NutrientRepository;
import com.reportgenerator.nutrition_report.repository.UserRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class ReportService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NutrientRepository nutrientRepository;

    public void generateReport(Long userId) throws JRException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        List<Nutrient> nutrients = nutrientRepository.findByUser_UserId(userId);


            // Load the JRXML file using ClassPathResource
            String FilePath = "D:\\course\\projects\\sprinboot\\nutrition_report\\nutrition_report\\src\\main\\resources\\templates\\nutrition_report.jrxml";

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("firstName", user.getFirstName());
            parameters.put("lastName", user.getLastName());
            parameters.put("dob", user.getDOB());
            parameters.put("age", user.getAge());
            parameters.put("nutritionDataSet", new JRBeanCollectionDataSource(nutrients));

            JasperReport report = JasperCompileManager.compileReport(FilePath);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(print, "D:\\course\\projects\\sprinboot\\nutrition_report\\nutrition_report\\src\\main\\resources\\static\\kj.pdf");
            System.out.println("Report generated successfully");

    }
}
