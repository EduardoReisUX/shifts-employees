package repositories;

import java.util.List;
import java.util.UUID;

import entities.Shift;

public interface IShiftRepository {
    List<Shift> getShifts();

    Shift findShiftByID(UUID id);

    Shift findShiftByCostLimit(int cost_limit);

    String findRequirementByDescription(UUID id, String description);

    void create(String[] requirements, int cost_limit);

    void delete(UUID id);
}
