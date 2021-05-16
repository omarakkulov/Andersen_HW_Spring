package ru.akkulov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private int id;
    private String name;
    private String customer;
    private int duration;
    private String methodology;
    private int team_id;

    @Override
    public String toString() {
        return "Id=" + id +
                ", Название проекта='" + name + '\'' +
                ", Заказчик='" + customer + '\'' +
                ", Длительность=" + duration +
                ", Методология='" + methodology + '\'' +
                ", Id команды в проекте=" + team_id;
    }
}
