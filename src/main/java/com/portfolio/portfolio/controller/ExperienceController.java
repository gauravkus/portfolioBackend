package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.Experience;
import com.portfolio.portfolio.service.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin(origins = "*")
public class ExperienceController {

    private final ExperienceService service;

    public ExperienceController(ExperienceService service) {
        this.service = service;
    }


    @GetMapping
    public List<Experience> getAllExperiences() {
        return service.getAllExperiences();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperience(@PathVariable Long id) {
        return ResponseEntity.ok(service.getExperienceById(id));
    }


    @PostMapping
    public Experience saveExperience(@RequestBody Experience experience) {
        return service.saveExperience(experience);
    }


    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return service.updateExperience(id, experience);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        service.deleteExperience(id);
        return ResponseEntity.noContent().build();
    }
}
