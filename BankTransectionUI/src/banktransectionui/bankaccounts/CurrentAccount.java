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
public class CurrentAccount extends BankAccount{
    
    public CurrentAccount(Client client, double balance) {
        super(client, balance);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount * 1.01);
    }
    
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }
}
