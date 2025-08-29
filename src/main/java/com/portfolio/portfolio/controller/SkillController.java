package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.Skill;
import com.portfolio.portfolio.repository.SkillRepository; // Import the SkillRepository
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GetMapping
    public List<Skill> all(){

        return skillRepository.findAll();
    }

    @PostMapping
    public Skill create(@RequestBody Skill s) {

        return skillRepository.save(s);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill in) {

        Skill s = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found with ID: " + id));
        s.setName(in.getName());
        s.setProficiency(in.getProficiency());
        return skillRepository.save(s);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable Long id) {
        skillRepository.deleteById(id);
    }
}
