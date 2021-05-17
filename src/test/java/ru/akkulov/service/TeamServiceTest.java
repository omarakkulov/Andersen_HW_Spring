package ru.akkulov.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.akkulov.model.Team;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamServiceTest {
    private static TeamService service;

    @BeforeAll
    static void doBefore() {
        service = new TeamService();
    }

    @Test
    void createAndGetAll() {
        List<Team> teamList = service.getAll();
        int resCount = teamList.size() + 1;

        Team team = new Team();
        team.setName("MOOOOON");

        service.create(team);

        teamList = service.getAll();

        assertEquals(resCount, teamList.size());

        int id = teamList.get(teamList.size() - 1).getId();
        service.deleteOne(id);
    }

    @Test
    void getById() {
        Team team = new Team();
        team.setName("MOOOOON");

        service.create(team);

        List<Team> teamList = service.getAll();
        int id = teamList.get(teamList.size() - 1).getId();
        String name = teamList.get(teamList.size() - 1).getName();

        assertEquals(team.getName(), name);

        service.deleteOne(id);
    }

    @Test
    void updateOne() {
        Team team = new Team();
        team.setName("MOOOOON");

        service.create(team);

        List<Team> teamList = service.getAll();
        int id = teamList.get(teamList.size() - 1).getId();

        team.setName("MON");
        service.updateOne(id, team.getName());

        Team team1 = service.getById(id);

        assertEquals(team.getName(), team1.getName());

        service.deleteOne(id);
    }

    @Test
    void deleteOne() {
        Team team = new Team();
        team.setName("MOOOOON");

        service.create(team);

        List<Team> teamList = service.getAll();
        int count = teamList.size() - 1;

        service.deleteOne(teamList.get(teamList.size() - 1).getId());

        teamList = service.getAll();

        assertEquals(count, teamList.size());
    }
}