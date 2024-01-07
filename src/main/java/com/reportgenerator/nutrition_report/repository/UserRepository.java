package com.reportgenerator.nutrition_report.repository;

import com.reportgenerator.nutrition_report.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
