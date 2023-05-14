import java.util.ArrayList;
import java.util.List;

// import entities.Employee;
import entities.Shift;
// import repositories.EmployeeRepository;
import repositories.ShiftRepository;

public class main {
    public static void main(String[] args) {
        // List<Employee> employeesInMemory = new ArrayList<>();
        List<Shift> shiftsInMemory = new ArrayList<>();

        ShiftRepository shiftRepository = new ShiftRepository(shiftsInMemory);
        // EmployeeRepository employeeRepository = new
        // EmployeeRepository(employeesInMemory);

        String[] requirements = { "Proatividade", "Java Avançado" };
        int cost_limit = 10;

        shiftRepository.create(requirements, cost_limit);

        Shift shift_test = shiftRepository.findShiftByCostLimit(10);

        System.out.println("UUID: " + shift_test.getId());
        System.out.println("requisito[0]: " + shift_test.getRequirements()[0]);
        System.out.println("custo limite: " + shift_test.getBudget());
    }

}
