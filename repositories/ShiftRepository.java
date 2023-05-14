package repositories;

import java.util.List;
import java.util.UUID;

import entities.Shift;

public class ShiftRepository implements IShiftRepository {
    private List<Shift> shiftsInMemory;

    public ShiftRepository(List<Shift> shiftsInMemory) {
        this.shiftsInMemory = shiftsInMemory;
    }

    public List<Shift> getShifts() {
        return shiftsInMemory;
    }

    public Shift findShiftByID(UUID id) {
        for (Shift shift : shiftsInMemory) {
            if (shift.getId().equals(id)) {
                return shift;
            }
        }

        throw new Error("Turno não encontrado!");
    }

    public Shift findShiftByCostLimit(int cost_limit) {
        for (Shift shift : shiftsInMemory) {
            if (shift.getBudget() == cost_limit) {
                return shift;
            }
        }

        throw new Error("Turno não encontrado!");
    }

    public String findRequirementByDescription(UUID id, String description) {
        // TODO: será que é isso mesmo que quero?
        Shift shift = findShiftByID(id);

        for (String requirement : shift.getRequirements()) {
            if (requirement.contains(description)) {
                return requirement;
            }
        }

        throw new Error("Requisito não encontrado!");
    }

    public void delete(UUID id) {
        Shift shift = findShiftByID(id);

        shiftsInMemory.remove(shift);
    }

    public void create(String[] requirements, int cost_limit) {
        Shift shift = new Shift(requirements, cost_limit);

        shiftsInMemory.add(shift);
    }
}
