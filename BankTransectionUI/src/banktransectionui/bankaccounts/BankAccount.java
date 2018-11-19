/**
 * Name: Asif Ahmed Chowdhury
 * ID: 2017100000015
 * Assignment: Banking System App Demo
 */

package banktransectionui.bankaccounts;
import banktransectionui.Client;
import java.time.LocalDateTime;
import java.time.LocalDate;
import banktransectionui.Client;
import banktransectionui.Name;

public class BankAccount {
    private Client client;
    protected double balance;
    private LocalDateTime accCreationDateTime;

    public BankAccount(Client client) {
        this.client = client;
        this.balance = 0.0;
        this.accCreationDateTime = LocalDateTime.now();
    }

    public BankAccount(Client client, double balance) {
        this.client = client;
        this.balance = balance;
        this.accCreationDateTime = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }
    
    public void withdraw(double amount) {
        if(amount <= balance && amount > 0)
            balance -= amount;
    }
    
    public void deposit(double amount) {
        if(amount > 0)
            balance += amount;
    }
    
    @Override
    public String toString() {
        return String.format("%s;%.2f", client.toString(), balance);
    }
    
    
}


