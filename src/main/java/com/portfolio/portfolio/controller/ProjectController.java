package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }
        // Fetch All Data
    @GetMapping()
    public Page<Project> list(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "6") int size,
                              @RequestParam(defaultValue = "title") String sort) {
        return service.list(page, size, sort);
    }
        // Fetch by ID
    @GetMapping("/{id}")
    public Project get(@PathVariable Long id) {
        return service.get(id);
    }
        // Create
    @PostMapping
    public Project create(@RequestBody Project in)
    {
        return service.create(in);
    }
    //Full updation
    @PutMapping("/{id}")
    public Project update(@PathVariable Long id,@RequestBody Project in){
        return service.update(id, in);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  delete(Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
