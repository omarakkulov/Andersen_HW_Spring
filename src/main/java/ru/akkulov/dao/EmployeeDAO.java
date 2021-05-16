package ru.akkulov.dao;

import org.springframework.stereotype.Component;
import ru.akkulov.connection.MyConnectionPool;
import ru.akkulov.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    // create
    private static final String ADD_SQL_QUERY = "INSERT INTO employee (first_name, last_name, email, phone, date_of_birth, " +
            "experience, date_of_employment, skill_level, eng_level, skype, team_id, project_id) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    // read
    private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM employee;";

    private static final String GET_BY_ID_SQL_QUERY = "SELECT id, first_name, last_name, email, phone, date_of_birth, " +
            "experience, date_of_employment, skill_level, eng_level, skype, team_id, project_id " +
            "FROM employee WHERE id=?;";
    // update
    private static final String UPDATE_ONE_SQL_QUERY = "UPDATE employee SET first_name=?, last_name=?, email=?, phone=?, date_of_birth=?, " +
            "experience=?, date_of_employment=?, skill_level=?, eng_level=?, skype=? " +
            "WHERE id=?;";
    // delete
    private static final String DELETE_BY_ID_SQL_QUERY = "DELETE FROM employee WHERE id=?;";


    public void create(Employee employee) {
        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_SQL_QUERY)
        ) {
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getDate_of_birth());
            preparedStatement.setInt(6, employee.getExperience());
            preparedStatement.setString(7, employee.getDate_of_employment());
            preparedStatement.setString(8, employee.getSkill_level());
            preparedStatement.setString(9, employee.getEng_level());
            preparedStatement.setString(10, employee.getSkype());
            preparedStatement.setInt(11, employee.getTeam_id());
            preparedStatement.setInt(12, employee.getProject_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Employee> readAll() {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL_QUERY)
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setDate_of_birth(resultSet.getString("date_of_birth"));
                employee.setExperience(resultSet.getInt("experience"));
                employee.setDate_of_employment(resultSet.getString("date_of_employment"));
                employee.setSkill_level(resultSet.getString("skill_level"));
                employee.setEng_level(resultSet.getString("eng_level"));
                employee.setSkype(resultSet.getString("skype"));
                employee.setTeam_id(resultSet.getInt("team_id"));
                employee.setProject_id(resultSet.getInt("project_id"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public Employee getById(int id) {
        Employee employee = new Employee();

        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL_QUERY)
        ) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setDate_of_birth(resultSet.getString("date_of_birth"));
                employee.setExperience(resultSet.getInt("experience"));
                employee.setDate_of_employment(resultSet.getString("date_of_employment"));
                employee.setSkill_level(resultSet.getString("skill_level"));
                employee.setEng_level(resultSet.getString("eng_level"));
                employee.setSkype(resultSet.getString("skype"));
                employee.setTeam_id(resultSet.getInt("team_id"));
                employee.setProject_id(resultSet.getInt("project_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    public void updateOne(Employee employee, int id) {
        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ONE_SQL_QUERY)
        ) {
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getDate_of_birth());
            preparedStatement.setInt(6, employee.getExperience());
            preparedStatement.setString(7, employee.getDate_of_employment());
            preparedStatement.setString(8, employee.getSkill_level());
            preparedStatement.setString(9, employee.getEng_level());
            preparedStatement.setString(10, employee.getSkype());
            preparedStatement.setInt(11, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteOne(int id) {
        try (Connection connection = MyConnectionPool.create().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL_QUERY)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
