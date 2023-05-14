package repositories;

import java.util.List;
import java.util.UUID;

import entities.Employee;

public interface IEmployeeRepository {
    List<Employee> getEmployees();

    Employee findEmployeeByID(UUID id);

    Employee findEmployeeByCost(int cost);

    String findSkillByName(UUID id, String name);

    void create(String[] skills, int cost, int disponibility);

    void delete(UUID id);
}
