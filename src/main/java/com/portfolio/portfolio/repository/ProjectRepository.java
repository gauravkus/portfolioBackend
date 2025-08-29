package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository  extends JpaRepository<Project, Long> {
}
