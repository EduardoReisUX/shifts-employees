package repositories;

import java.util.List;
import java.util.UUID;

import entities.Employee;

public class EmployeeRepository implements IEmployeeRepository {
    private List<Employee> employeesInMemory;

    public EmployeeRepository(List<Employee> employeesInMemory) {
        this.employeesInMemory = employeesInMemory;
    }

    public List<Employee> getEmployees() {
        return employeesInMemory;
    }

    public Employee findEmployeeByID(UUID id) {
        for (Employee employee : employeesInMemory) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }

        throw new Error("Funcionário não encontrado!");
    }

    public Employee findEmployeeByCost(int cost) {
        for (Employee employee : employeesInMemory) {
            if (employee.getCost() == cost) {
                return employee;
            }
        }

        throw new Error("Turno não encontrado!");
    }

    public String findSkillByName(UUID id, String name) {
        Employee employee = findEmployeeByID(id);

        for (String skill : employee.getSkills()) {
            if (skill.contains(name)) {
                return skill;
            }
        }

        throw new Error("Habilidade do funcionário não encontrada!");
    }

    public void create(String[] skills, int cost, int disponibility) {
        Employee employee = new Employee(skills, cost, disponibility);

        employeesInMemory.add(employee);
    }

    public void delete(UUID id) {
        Employee employee = findEmployeeByID(id);

        employeesInMemory.remove(employee);
    }

}
