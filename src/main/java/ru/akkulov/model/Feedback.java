package ru.akkulov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private int id;
    private String description;
    private String date;
    private int employee_id;

    @Override
    public String toString() {
        return "id=" + id +
                ", Описание='" + description + '\'' +
                ", Дата='" + date + '\'' +
                ", Id работника=" + employee_id;
    }
}
