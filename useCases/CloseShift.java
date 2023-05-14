import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import entities.Employee;
import entities.Shift;
import repositories.ShiftRepository;

public class CloseShift {
    private ShiftRepository shiftRepository;

    public CloseShift(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public boolean hasAllSkillsMatchingRequirements(List<Employee> employees, String[] requirements) {
        List<String> skillsList = new ArrayList<>();

        for (Employee employee : employees) {
            for (String skill : employee.getSkills()) {
                skillsList.add(skill);
            }
        }

        Set<String> skillsSet = new HashSet<String>(skillsList);

        for (String requirement : requirements) {
            if (!skillsSet.contains(requirement)) {
                return false;
            }
        }

        return true;
    }

    public void execute(UUID id) {
        // Buscar turno pelo id
        Shift shift = shiftRepository.findShiftByID(id);

        if (shift == null) {
            throw new Error("ID do turno não encontrado");
        }

        // Conferir se todos os requisitos batem
        String[] requirements = shift.getRequirements();
        List<Employee> employees = shift.getEmployees();

        if (!hasAllSkillsMatchingRequirements(employees, requirements)) {
            throw new Error("Os requisitos do turno não foram totalmente cumpridos!");
        }

        // Fechar o turno.
        shift.setClosed(true);
    }
}
