
import java.util.Set;
import java.util.UUID;

import entities.Employee;
import entities.Shift;
import repositories.EmployeeRepository;
import repositories.ShiftRepository;

public class AssignEmployeeToShift {
    private EmployeeRepository employeeRepository;
    private ShiftRepository shiftRepository;

    public AssignEmployeeToShift(EmployeeRepository employeeRepository, ShiftRepository shiftRepository) {
        this.employeeRepository = employeeRepository;
        this.shiftRepository = shiftRepository;
    }

    public boolean hasMatchingSkill(Set<String> skills, String[] requirements) {
        for (String requirement : requirements) {
            if (skills.contains(requirement)) {
                return true;
            }
        }
        return false;
    }

    public void execute(UUID employeeID, UUID shiftID) {
        Employee employee = employeeRepository.findEmployeeByID(employeeID);

        Shift shift = shiftRepository.findShiftByID(shiftID);

        String[] requirements = shift.getRequirements();
        Set<String> skills = Set.of(employee.getSkills());

        if (!hasMatchingSkill(skills, requirements)) {
            throw new Error("Nenhuma habilidade do funcionário bate com qualquer um dos requerimentos do turno!");
        }

        int cost = employee.getCost();
        int budget = shift.getBudget();

        if (cost > budget) {
            throw new Error("O custo do funcionário é maior que o orçamento!");
        }

        shift.addEmployee(employee);
        System.out.println("OK - O funcionário foi atribuido ao turno.");
    }
}
