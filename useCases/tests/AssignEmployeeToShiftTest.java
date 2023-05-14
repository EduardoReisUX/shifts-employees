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

public class AssignEmployeeToShiftTest {
    List<Employee> employees;
    List<Shift> shifts;

    EmployeeRepository employeeRepository;
    ShiftRepository shiftRepository;

    AssignEmployeeToShift assignEmployeeToShift;

    @Before
    public void setup() {
        employees = new ArrayList<Employee>();
        shifts = new ArrayList<Shift>();

        employeeRepository = new EmployeeRepository(employees);
        shiftRepository = new ShiftRepository(shifts);

        assignEmployeeToShift = new AssignEmployeeToShift(employeeRepository, shiftRepository);
    }

    @Test
    public void shouldBeAbleToAssignEmployeeToShift() {
        // Arrange
        employeeRepository.create(new String[] { "skill1", "skill2" }, 50, 0);
        shiftRepository.create(new String[] { "skill1", "skill2" }, 100);

        Employee employee = employeeRepository.findEmployeeByCost(50);
        Shift shift = shiftRepository.findShiftByCostLimit(100);

        // Act
        assignEmployeeToShift.execute(employee.getId(), shift.getId());

        // Assert
        assertEquals(shift.getEmployees().isEmpty(), false);
        assertEquals(shift.getEmployees().size(), 1);
    }

    @Test
    public void shouldBeAbleToAssignIfAtLeastOneSkillMatchRequirements() {
        // Arrange
        employeeRepository.create(new String[] { "skill2" }, 50, 0);
        shiftRepository.create(new String[] { "skill1", "skill2" }, 100);

        Employee employee = employeeRepository.findEmployeeByCost(50);
        Shift shift = shiftRepository.findShiftByCostLimit(100);

        // Act
        assignEmployeeToShift.execute(employee.getId(), shift.getId());

        // Assert
        assertEquals(shift.getEmployees().isEmpty(), false);
        assertEquals(shift.getEmployees().size(), 1);
    }

    @Test
    public void shouldNotBeAbleToAssignIfNoSkillsMatchRequirements() {
        // Arrange
        employeeRepository.create(new String[] { "skill4", "skill3" }, 50, 0);
        shiftRepository.create(new String[] { "skill1", "skill2" }, 100);

        Employee employee = employeeRepository.findEmployeeByCost(50);
        Shift shift = shiftRepository.findShiftByCostLimit(100);

        // Act
        try {
            assignEmployeeToShift.execute(employee.getId(), shift.getId());
            fail("FALHA - assignEmployeeToShift.execute() não deveria ter sido executado com sucesso!");
        } catch (Error e) {
            // Assert
            assertEquals("Nenhuma habilidade do funcionário bate com qualquer um dos requerimentos do turno!",
                    e.getMessage());
        }

    }

    @Test
    public void shouldNotBeAbleToAssignIfCostIsGreaterThanBudget() {
        // Arrange
        employeeRepository.create(new String[] { "skill1", "skill2" }, 150, 0);
        shiftRepository.create(new String[] { "skill1", "skill2" }, 100);

        Employee employee = employeeRepository.findEmployeeByCost(150);
        Shift shift = shiftRepository.findShiftByCostLimit(100);

        // Act
        try {
            assignEmployeeToShift.execute(employee.getId(), shift.getId());
            fail("FALHA - assignEmployeeToShift.execute() não deveria ter sido executado com sucesso!");
        } catch (Error e) {
            // Assert
            assertEquals("O custo do funcionário é maior que o orçamento!",
                    e.getMessage());
        }

    }

}