package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Skill;
import com.portfolio.portfolio.repository.SkillRepository;

import java.util.List;

public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill saveSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }

    public Skill getSkillById(Long id){
        return skillRepository.findById(id).orElseThrow(null);
    }

    public Skill updateSkill(Long id, Skill updatedSkill) {
        Skill skill = skillRepository.findById(id).orElse(null);
        if (skill != null) {
            skill.setName(updatedSkill.getName());
            skill.setProficiency(updatedSkill.getProficiency());
            return skillRepository.save(skill);
        }
        return null;
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

}
