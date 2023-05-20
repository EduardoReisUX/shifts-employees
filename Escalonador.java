import java.util.ArrayList;
import java.util.List;

import entities.Employee;
import entities.Shift;
import repositories.EmployeeRepository;
import repositories.ShiftRepository;

public class Escalonador {
    public static void main(String[] args) {
        // Limpa o terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Array de funcionários e turnos
        List<Employee> employees = new ArrayList<>();
        List<Shift> shifts = new ArrayList<>();

        // Funções que manipulam os arrays de funcionários e turnos (criar, procurar,
        // deletar)
        EmployeeRepository employeeRepository = new EmployeeRepository(employees);
        ShiftRepository shiftRepository = new ShiftRepository(shifts);

        String[] requirements = { "Proatividade", "Java Avançado" };
        int cost_limit = 10;

        // Criar turno
        shiftRepository.createShift(requirements, cost_limit);

        // Localizar turno pelo orçamento
        Shift shift = shiftRepository.findShiftByBudget(10);

        // Printar informações do turno encontrado
        // shift.printQuantity();
        shift.printInfos();

        String[] skills = { "Java Avançado" };
        int cost = 5;

        // Criar funcionário
        employeeRepository.createEmployee(skills, cost);

        // Localizar funcionário pelo custo
        Employee employee = employeeRepository.findEmployeeByCost(5);

        // Printar informações do funcionário encontrado
        // employee.printQuantity();
        employee.printInfos();

        // CASO DE USO - Associar um empregado a um turno
        AssignEmployeeToShift assignEmployeeToShift = new AssignEmployeeToShift(employeeRepository, shiftRepository);

        // Executar caso de uso
        assignEmployeeToShift.execute(employee.getId(), shift.getId());

        // CASO DE USO - Fechar um turno
        CloseShift closeShift = new CloseShift(shiftRepository);

        // Executar.
        // Irá ocorrer um erro pois os requisitos do turno não foram completamente
        // cumpridos
        closeShift.execute(shift.getId());

        // Verificar se funcionário foi add ao turno e se turno foi fechado
        shift.printInfos();
    }

}
