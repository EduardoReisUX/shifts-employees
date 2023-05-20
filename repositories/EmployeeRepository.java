package repositories;

import java.util.List;
import java.util.UUID;

import entities.Employee;

public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee findEmployeeByID(UUID id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }

        throw new Error("Funcionário não encontrado!");
    }

    public Employee findEmployeeByCost(int cost) {
        for (Employee employee : employees) {
            if (employee.getCost() == cost) {
                return employee;
            }
        }

        throw new Error("Turno não encontrado!");
    }

    public void createEmployee(String[] skills, int cost) {
        Employee employee = new Employee(skills, cost);

        employees.add(employee);
    }

    public void deleteEmployee(UUID id) {
        Employee employee = findEmployeeByID(id);

        employees.remove(employee);
    }

}
