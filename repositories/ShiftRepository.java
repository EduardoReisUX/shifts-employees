package repositories;

import java.util.List;
import java.util.UUID;

import entities.Shift;

public class ShiftRepository {
    private List<Shift> shifts;

    public ShiftRepository(List<Shift> shifts) {
        this.shifts = shifts;
    }

    public Shift findShiftByID(UUID id) {
        for (Shift shift : shifts) {
            if (shift.getId().equals(id)) {
                return shift;
            }
        }

        throw new Error("Turno não encontrado!");
    }

    public Shift findShiftByBudget(int cost_limit) {
        for (Shift shift : shifts) {
            if (shift.getBudget() == cost_limit) {
                return shift;
            }
        }

        throw new Error("Turno não encontrado!");
    }

    public void deleteShift(UUID id) {
        Shift shift = findShiftByID(id);

        shifts.remove(shift);
    }

    public void createShift(String[] requirements, int cost_limit) {
        Shift shift = new Shift(requirements, cost_limit);

        shifts.add(shift);
    }
}
