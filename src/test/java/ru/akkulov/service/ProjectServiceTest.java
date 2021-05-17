package ru.akkulov.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.akkulov.model.Project;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectServiceTest {
    private static ProjectService service;

    @BeforeAll
    static void doBefore() {
        service = new ProjectService();
    }

    @Test
    void createAndGetAll() {
        List<Project> projectList = service.getAll();
        int resCount = projectList.size() + 1;

        Project project = new Project();
        project.setName("Misha");
        project.setCustomer("OAO");
        project.setDuration(15);
        project.setMethodology("aop");
        project.setTeam_id(3);

        service.create(project);

        projectList = service.getAll();

        assertEquals(resCount, projectList.size());
        int id = projectList.get(projectList.size() - 1).getId();
        service.deleteOne(id);
    }

    @Test
    void getById() {
        Project project = new Project();
        project.setName("Misha");
        project.setCustomer("OAO");
        project.setDuration(15);
        project.setMethodology("aop");
        project.setTeam_id(3);

        service.create(project);

        List<Project> projectList = service.getAll();
        int id = projectList.get(projectList.size() - 1).getId();
        String customer = projectList.get(projectList.size() - 1).getCustomer();

        assertEquals(project.getCustomer(), customer);

        service.deleteOne(id);
    }

    @Test
    void updateOne() {
        Project project = new Project();
        project.setName("Misha");
        project.setCustomer("OAO");
        project.setDuration(15);
        project.setMethodology("aop");
        project.setTeam_id(3);

        service.create(project);

        List<Project> projectList = service.getAll();

        int id = projectList.get(projectList.size() - 1).getId();

        project.setDuration(15);
        project.setMethodology("OOP");

        service.updateOne(project, id);

        Project project1 = service.getById(id);

        assertEquals(project.getDuration(), project1.getDuration());
        assertEquals(project.getMethodology(), project1.getMethodology());

        service.deleteOne(id);
    }

    @Test
    void deleteOne() {
        Project project = new Project();
        project.setName("Misha");
        project.setCustomer("OAO");
        project.setDuration(15);
        project.setMethodology("aop");
        project.setTeam_id(3);

        service.create(project);

        List<Project> projectList = service.getAll();
        int count = projectList.size() - 1;

        service.deleteOne(projectList.get(projectList.size() - 1).getId());

        projectList = service.getAll();

        assertEquals(count, projectList.size());
    }
}