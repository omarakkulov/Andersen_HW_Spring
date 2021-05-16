package ru.akkulov.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akkulov.model.Team;
import ru.akkulov.service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    private TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping()
    public String getTeams(Model model) {
        List<Team> teamList = teamService.getAll();

        model.addAttribute("teamList", teamList);
        model.addAttribute("newTeam", new Team());
        model.addAttribute("deleteTeam", new Team());
        model.addAttribute("updateTeam", new Team());
        model.addAttribute("getById", new Team());
        return "team";
    }

    @PostMapping("/create")
    public String createTeam(@ModelAttribute("team") Team team) {
        teamService.create(team);
        return "redirect:/team";
    }

    @PostMapping("/delete")
    public String deleteTeam(@ModelAttribute("deleteTeam") Team team) {
        teamService.deleteOne(team.getId());
        return "redirect:/team";
    }

    @PostMapping("/update")
    public String updateTeam(@ModelAttribute("updateTeam") Team team) {
        teamService.updateOne(team.getId(), team.getName());
        return "redirect:/team";
    }

    @GetMapping("/get")
    public String getById(@ModelAttribute("getById") Team team, Model model) {
        model.addAttribute("get_by_id", teamService.getById(team.getId()));
        return "team_get_by_id";
    }
}
