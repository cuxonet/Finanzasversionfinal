package es.uniovi.miw.ws.appfinanzas.finanzasaplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "expenses") // Nombre de la tabla en la base de datos (opcional)
@Setter
@Getter
public class Expense {
    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExpense;
    private String description;
    private double amount;
    private String expenseType;

    // Constructor vacío (necesario para JPA)
    public Expense() {}

    // Constructor completo
    public Expense(int idExpense, String description, double amount, String expenseType) {
        this.idExpense = idExpense;
        this.description = description;
        this.amount = amount;
        this.expenseType = expenseType;
    }

    public void setIdExpense(int idExpense) {
        this.idExpense = idExpense;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
}
