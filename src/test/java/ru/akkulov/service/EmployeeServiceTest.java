package ru.akkulov.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.akkulov.model.Employee;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceTest {
    private static EmployeeService service;

    @BeforeAll
    static void doBefore() {
        service = new EmployeeService();
    }

    @Test
    void createAndGetAll() {
        List<Employee> employeeList = service.getAll();
        int employeesCount1 = employeeList.size();
        int how_much_should_be = employeesCount1 + 1;

        Employee employee = new Employee();
        employee.setFirst_name("xxx");
        employee.setLast_name("yyy");
        employee.setEmail("x@mail.ru");
        employee.setPhone("89898988");
        employee.setDate_of_birth("15.05.1994");
        employee.setExperience(5);
        employee.setDate_of_employment("25.08.2020");
        employee.setSkill_level("senior");
        employee.setEng_level("a1");
        employee.setSkype("asasdasd");
        employee.setTeam_id(36);
        employee.setProject_id(7);

        service.create(employee);

        employeeList = service.getAll();
        int id = employeeList.get(employeeList.size() - 1).getId();

        assertEquals(how_much_should_be, employeeList.size());

        service.deleteOne(id);
    }

    @Test
    void getById() {
        Employee employee = new Employee();
        employee.setFirst_name("xxx");
        employee.setLast_name("yyy");
        employee.setEmail("x@mail.ru");
        employee.setPhone("89898988");
        employee.setDate_of_birth("15.05.1994");
        employee.setExperience(5);
        employee.setDate_of_employment("25.08.2020");
        employee.setSkill_level("senior");
        employee.setEng_level("a1");
        employee.setSkype("asasdasd");
        employee.setTeam_id(36);
        employee.setProject_id(7);

        service.create(employee);

        List<Employee> employeeList = service.getAll();

        int id = employeeList.get(employeeList.size() - 1).getId();

        Employee employee_temp = service.getById(id);

        assertEquals(employee.getFirst_name(), employee_temp.getFirst_name());

        service.deleteOne(id);
    }

    @Test
    void updateOne() {
        Employee employee = new Employee();
        employee.setFirst_name("GAGAGA");
        employee.setLast_name("yyy");
        employee.setEmail("x@mail.ru");
        employee.setPhone("2000");
        employee.setDate_of_birth("15.05.1994");
        employee.setExperience(5);
        employee.setDate_of_employment("25.08.2020");
        employee.setSkill_level("senior");
        employee.setEng_level("a1");
        employee.setSkype("asasdasd");
        employee.setTeam_id(36);
        employee.setProject_id(7);

        service.create(employee);

        List<Employee> employeeList = service.getAll();
        int id = employeeList.get(employeeList.size() - 1).getId();

        employee.setSkype("blablabla");
        employee.setPhone("88888");

        service.updateOne(employee, id);

        Employee employee_temp = service.getById(id);

        assertEquals(employee.getSkype(), employee_temp.getSkype());
        assertEquals(employee.getPhone(), employee_temp.getPhone());

        service.deleteOne(id);
    }

    @Test
    void deleteOne() {
        Employee employee = new Employee();
        employee.setFirst_name("GAGAGA");
        employee.setLast_name("yyy");
        employee.setEmail("x@mail.ru");
        employee.setPhone("2000");
        employee.setDate_of_birth("15.05.1994");
        employee.setExperience(5);
        employee.setDate_of_employment("25.08.2020");
        employee.setSkill_level("senior");
        employee.setEng_level("a1");
        employee.setSkype("asasdasd");
        employee.setTeam_id(36);
        employee.setProject_id(7);

        service.create(employee);

        List<Employee> employeeList = service.getAll();
        int resultCount = employeeList.size() - 1;

        service.deleteOne(employeeList.get(employeeList.size() - 1).getId());

        employeeList = service.getAll();

        assertEquals(resultCount, employeeList.size());
    }
}