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
}
