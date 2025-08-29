package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
}
