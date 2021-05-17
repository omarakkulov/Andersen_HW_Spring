package ru.akkulov.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.akkulov.dao.TeamDAO;
import ru.akkulov.model.Team;

import java.util.List;

@Data
@Component
public class TeamService {
    private TeamDAO teamDAO;

    @Autowired
    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public TeamService() {
        teamDAO = new TeamDAO();
    }

    public void create(Team team) {
        teamDAO.create(team);
    }

    public List<Team> getAll() {
        return teamDAO.readAll();
    }

    public Team getById(int id) {
        return teamDAO.getById(id);
    }

    public void updateOne(int team_id, String new_team_name) {
        teamDAO.updateOne(team_id, new_team_name);
    }

    public void deleteOne(int team_id) {
        teamDAO.deleteOne(team_id);
    }
}
