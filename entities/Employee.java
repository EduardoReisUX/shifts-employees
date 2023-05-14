package entities;

import java.util.UUID;

public class Employee {
    private static int quantity = 0;
    private UUID id;
    private String[] skills;
    private int cost;
    private int disponibility;

    public Employee(String[] skills, int cost, int disponibility) {
        this.id = UUID.randomUUID();
        this.skills = skills;
        this.cost = cost;
        // this.disponibility = disponibility;
        quantity++;
    }

    public static int getQuantity() {
        return quantity;
    }

    public UUID getId() {
        return id;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(int disponibility) {
        this.disponibility = disponibility;
    }
}