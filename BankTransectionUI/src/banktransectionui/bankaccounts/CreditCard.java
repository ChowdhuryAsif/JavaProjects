/**
 * Name: Asif Ahmed Chowdhury
 * ID: 2017100000015
 * Assignment: Banking System App Demo
 */

package banktransectionui.bankaccounts;

import banktransectionui.Client;
import banktransectionui.Name;
import banktransectionui.bankaccounts.BankAccount;

/**
 *
 * @author chowdhuryasif
 */
public class CreditCard extends BankAccount{
    
    private double creditLimit;
    
    public CreditCard(Client client, double creditLimit) {
        super(client);
        this.creditLimit = creditLimit;
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + creditLimit)
            balance = balance - amount;
    }
    
    @Override
    public void deposit(double amount) {
        
        super.deposit(amount);
    }
    
    @Override
    public String toString() {
        return String.format("%s;%.2f", super.toString(), creditLimit);
    }
    
}
