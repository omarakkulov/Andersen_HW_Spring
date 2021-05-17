package ru.akkulov.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.akkulov.dao.EmployeeDAO;
import ru.akkulov.model.Employee;

import java.util.List;

@Data
@Component("employeeService")
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }

    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    public List<Employee> getAll() {
        return employeeDAO.readAll();
    }

    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    public void updateOne(Employee employee, int id) {
        employeeDAO.updateOne(employee, id);
    }

    public void deleteOne(int id) {
        employeeDAO.deleteOne(id);
    }
}
