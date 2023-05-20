package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Shift {
    private static int quantity = 0;
    private UUID id;
    private String[] requirements;
    private int currentCost;
    private int budget;
    private boolean isClosed;
    private List<Employee> employees;

    public Shift(String[] requirements, int budget) {
        this.id = UUID.randomUUID();
        this.requirements = requirements;
        this.budget = budget;
        this.isClosed = false;
        this.employees = new ArrayList<>();
        quantity++;

    }

    public static int getQuantity() {
        return quantity;
    }

    public static void setQuantity(int quantity) {
        Shift.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String[] getRequirements() {
        return requirements;
    }

    public void setRequirements(String[] requisitos) {
        this.requirements = requisitos;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    private void setCurrentCost(int currentCost) {
        this.currentCost = currentCost;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int custo_limite) {
        this.budget = custo_limite;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        setCurrentCost(employee.getCost());
    }

    public void printQuantity() {
        System.out.println("Quantidade de Turnos: " + Shift.quantity);
    }

    public void printInfos() {
        System.out.println("\n---------- TURNO " + this.id.toString().substring(0, 10) + "... ---------");

        System.out.println("Requisitos: ");
        if (this.getRequirements().length > 0) {
            for (String requirement : this.requirements) {
                System.out.println("\t" + requirement);
            }
        } else {
            System.out.println("Nenhum requisito associado ao turno");
        }

        System.out.println("Custo atual: " + this.currentCost);
        System.out.println("Orçamento: " + this.budget);

        if (isClosed) {
            System.out.println("Turno está fechado? SIM");
        } else {
            System.out.println("Turno está fechado? NÃO");
        }

        System.out.println("Funcionários: ");
        if (this.getEmployees().size() > 0) {
            for (Employee employee : this.employees) {
                System.out.println("\tUUID: " + employee.getId().toString().substring(0, 10) + "...");
            }
        } else {
            System.out.println("\tNenhum funcionário associado ao turno");
        }

    }
}
