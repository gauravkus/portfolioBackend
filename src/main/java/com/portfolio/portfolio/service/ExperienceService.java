package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Experience;
import com.portfolio.portfolio.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public Experience getExperienceById(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    public Experience updateExperience(Long id, Experience updatedExperience) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        if (experience != null) {
            experience.setCompany(updatedExperience.getCompany());
            experience.setRole(updatedExperience.getRole());
            experience.setStartDate(updatedExperience.getStartDate());
            experience.setEndDate(updatedExperience.getEndDate());
            experience.setDescription(updatedExperience.getDescription());
            return experienceRepository.save(experience);
        }
        return null;
    }
}