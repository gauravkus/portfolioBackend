package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.exception.NotFoundException;
import com.portfolio.portfolio.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository repo;

    public ProjectService(ProjectRepository repo) {
        this.repo = repo;
    }

    // Implementing Paging
    public Page<Project>list(int pageno,int size,String sort)
    {
        Pageable p = PageRequest.of(pageno,size, Sort.by(sort).ascending());
        return repo.findAll(p);
    }

    public Project get(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Project not found"));
    }

    public Project create(Project p) { return repo.save(p); }

    public Project update(Long id, Project in) {
        Project p = get(id);
        p.setTitle(in.getTitle());
        p.setDescription(in.getDescription());
        p.setTechStack(in.getTechStack());
        p.setGithubLink(in.getGithubLink());
        p.setDemoLink(in.getDemoLink());
        return repo.save(p);
    }

    public void delete(Long id) { repo.deleteById(id); }

}
