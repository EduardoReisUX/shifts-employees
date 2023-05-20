package entities;

import java.util.UUID;

public class Employee {
    private static int quantity = 0;
    private UUID id;
    private String[] skills;
    private int cost;

    public Employee(String[] skills, int cost) {
        this.id = UUID.randomUUID();
        this.skills = skills;
        this.cost = cost;
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

    public void printQuantity() {
        System.out.println("Quantidade de funcionários: " + Employee.quantity);
    }

    public void printInfos() {
        System.out.println("\n--------- FUNCIONÁRIO " + this.id.toString().substring(0, 10) + "... ---------");

        System.out.println("Habilidades: ");
        if (this.getSkills().length > 0) {
            for (String skill : this.skills) {
                System.out.println("\t" + skill);
            }
        } else {
            System.out.println("Nenhuma habilidade associado ao funcionário");
        }

        System.out.println("Custo: " + this.cost);

    }
}