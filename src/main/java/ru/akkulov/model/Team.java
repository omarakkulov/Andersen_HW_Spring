package ru.akkulov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Id=" + id +
                ", Название='" + name + '\'';
    }
}
