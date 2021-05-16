package ru.akkulov.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akkulov.model.Employee;
import ru.akkulov.model.Team;
import ru.akkulov.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployee(Model model) {
        List<Employee> employeeList = employeeService.getAll();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("newEmployee", new Employee());
        model.addAttribute("deleteEmployee", new Employee());
        model.addAttribute("updateEmployee", new Employee());
        model.addAttribute("getById", new Employee());

        return "employee";
    }

    @PostMapping("/create")
    public String newEmployee(@ModelAttribute("newEmployee") Employee employee) {
        employeeService.create(employee);
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("deleteEmployee") Employee employee) {
        employeeService.deleteOne(employee.getId());
        return "redirect:/employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("updateEmployee") Employee employee) {
        employeeService.updateOne(employee, employee.getId());
        return "redirect:/employee";
    }

    @GetMapping("/get")
    public String getById(@ModelAttribute("getById") Employee employee, Model model) {
        model.addAttribute("get_by_id", employeeService.getById(employee.getId()));
        return "employee_get_by_id";
    }
}
