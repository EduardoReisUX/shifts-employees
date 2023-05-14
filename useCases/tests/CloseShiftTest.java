import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Employee;
import entities.Shift;
import repositories.EmployeeRepository;
import repositories.ShiftRepository;

public class CloseShiftTest {
    List<Employee> employees;
    List<Shift> shifts;

    EmployeeRepository employeeRepository;
    ShiftRepository shiftRepository;

    AssignEmployeeToShift assignEmployeeToShift;
    CloseShift closeShift;

    @Before
    public void setup() {
        employees = new ArrayList<Employee>();
        shifts = new ArrayList<Shift>();

        employeeRepository = new EmployeeRepository(employees);
        shiftRepository = new ShiftRepository(shifts);

        assignEmployeeToShift = new AssignEmployeeToShift(employeeRepository, shiftRepository);
        closeShift = new CloseShift(shiftRepository);
    }

    @Test
    public void shouldBeAbleToCloseShift() {
        // Arrange
        employeeRepository.create(new String[] { "skill1", "skill2" }, 50, 0);
        shiftRepository.create(new String[] { "skill1", "skill2" }, 100);

        Employee employee = employeeRepository.findEmployeeByCost(50);
        Shift shift = shiftRepository.findShiftByCostLimit(100);

        assignEmployeeToShift.execute(employee.getId(), shift.getId());

        assertEquals(shift.getEmployees().isEmpty(), false);
        assertEquals(shift.getEmployees().size(), 1);

        // Act
        closeShift.execute(shift.getId());

        // Assert
        assertEquals(shift.isClosed(), true);
    }

    @Test
    public void shouldNotBeAbleToCloseShiftIfAllSkillsDoesntMatchRequirements() {
        // Arrange
        employeeRepository.create(new String[] { "skill2" }, 50, 0);
        shiftRepository.create(new String[] { "skill1", "skill2" }, 100);

        Employee employee = employeeRepository.findEmployeeByCost(50);
        Shift shift = shiftRepository.findShiftByCostLimit(100);

        assignEmployeeToShift.execute(employee.getId(), shift.getId());

        // Act
        try {
            closeShift.execute(shift.getId());
            fail("FALHA - closeShift.execute() não deveria ter sido executado com sucesso!");
        } catch (Error e) {
            // Assert
            assertEquals("Os requisitos do turno não foram totalmente cumpridos!", e.getMessage());
        }
    }
}
