package ru.akkulov.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akkulov.model.Employee;
import ru.akkulov.model.Project;
import ru.akkulov.service.ProjectService;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String getProjects(Model model) {
        List<Project> projectList = projectService.getAll();

        model.addAttribute("projectList", projectList);
        model.addAttribute("newProject", new Project());
        model.addAttribute("deleteProject", new Project());
        model.addAttribute("updateProject", new Project());
        model.addAttribute("getById", new Project());

        return "project";
    }

    @PostMapping("/create")
    public String newProject(@ModelAttribute("newProject") Project project) {
        projectService.create(project);
        return "redirect:/project";
    }

    @PostMapping("/delete")
    public String deleteProject(@ModelAttribute("deleteProject") Project project) {
        projectService.deleteOne(project.getId());
        return "redirect:/project";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("updateProject") Project project) {
        projectService.updateOne(project, project.getId());
        return "redirect:/project";
    }

    @GetMapping("/get")
    public String getById(@ModelAttribute("getById") Project project, Model model) {
        model.addAttribute("get_by_id", projectService.getById(project.getId()));
        return "project_get_by_id";
    }
}
