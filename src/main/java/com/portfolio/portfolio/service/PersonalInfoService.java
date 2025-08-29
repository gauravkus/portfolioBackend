package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.PersonalInfo;
import com.portfolio.portfolio.repository.PersonalInfoRepository;

import java.util.List;

public class PersonalInfoService {

    private PersonalInfoRepository personalInfoRepository;

    public PersonalInfoService(PersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }

    public List<PersonalInfo> getAllPersonalInfo(){
        return personalInfoRepository.findAll();
    }
    public PersonalInfo savePersonalInfo(PersonalInfo info) {
        return personalInfoRepository.save(info);
    }
    public PersonalInfo getPersonalInfoById(Long id) {
        return personalInfoRepository.findById(id).orElse(null);
    }
    public PersonalInfo updatePersonalInfo(Long id, PersonalInfo updatedInfo) {
        PersonalInfo info = personalInfoRepository.findById(id).orElse(null);
        if (info != null) {
            info.setName(updatedInfo.getName());
            info.setTitle(updatedInfo.getTitle());
            info.setBio(updatedInfo.getBio());
            info.setEmail(updatedInfo.getEmail());
            info.setPhone(updatedInfo.getPhone());
            info.setLinkedin(updatedInfo.getLinkedin());
            info.setGithub(updatedInfo.getGithub());


            return personalInfoRepository.save(info);
        }
        return null;
    }
}
