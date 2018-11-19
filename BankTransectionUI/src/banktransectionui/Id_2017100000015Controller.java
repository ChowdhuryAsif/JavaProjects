/**
 * Name: Asif Ahmed Chowdhury
 * ID: 2017100000015
 * Assignment: Banking System App Demo
 */

package banktransectionui;

import banktransectionui.bankaccounts.BankAccount;
import banktransectionui.bankaccounts.CreditCard;
import banktransectionui.bankaccounts.CurrentAccount;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author chowdhuryasif
 */
public class Id_2017100000015Controller implements Initializable {

    @FXML
    private Button signInButton;
    @FXML
    private Button addClientButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private DatePicker dobBDayField;
    @FXML
    private TextField contactField;
    @FXML
    private Button resetButton;
    @FXML
    private TextField acTypeField;
    @FXML
    private TextField branchField;
    @FXML
    private Button withdrawButton;
    @FXML
    private TextField withdrawAmountField;
    @FXML
    private TextField withdrawPassField;
    @FXML
    private Button depositButton;
    @FXML
    private TextField clientIDField;
    @FXML
    private TextField withdrawIDField;
    @FXML
    private TextField depositIDField;
    @FXML
    private TextField depositAmountField;
    @FXML
    private TextField depositContactField;
    @FXML
    private AnchorPane accountsDetailsPane;
    @FXML
    private GridPane signInGridPane;
    @FXML
    private TextField detailsClientIdField;
    @FXML
    private TextField detailsNameField;
    @FXML
    private TextField detailsACTypeField;
    @FXML
    private TextField detailsBalanceField;
    @FXML
    private TextField detailsContactField;

    private ObservableList <Client> clientList;
    private ObservableList <BankAccount> accounts;    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readFile();
        clearAddClientPanel();
        accountsDetailsPane.setVisible(false);
        signInGridPane.setVisible(true);
        
    }    

    @FXML
    private void signInButtonAction(ActionEvent event) {
        signInGridPane.setVisible(false);
        accountsDetailsPane.setVisible(true);
    }
    
    @FXML
    private void signOutButtonAction(ActionEvent event) {
        signInGridPane.setVisible(true);
        accountsDetailsPane.setVisible(false);
    }

    @FXML
    private void addClientButtonAction(ActionEvent event) {
        
        int clientID = Integer.parseInt(clientIDField.getText());
        Name name = new Name(firstNameField.getText(), lastNameField.getText());
        String contactNo = contactField.getText();
        LocalDate dob = dobBDayField.getValue();
        String accType = acTypeField.getText();
        String branch = branchField.getText();
        
        Client client = new Client(clientID, name, contactNo, dob, accType, branch);
        
        
        try (RandomAccessFile output = new RandomAccessFile("client.txt", "rw")) {
            
            long fileLength = output.length();
            output.seek(fileLength);
            
            clientList.add(client);
            output.writeBytes(client.toString() + "\n");
            
            createAccount();
            
            clearAddClientPanel();

        } catch (IOException ex) {
            System.out.println("Some IOException occured!\n" + ex.getMessage());
        }
        
        

    }

    @FXML
    private void resetButtonAction(ActionEvent event) {
        clearAddClientPanel();
    }

    @FXML
    private void withdrawButtonAction(ActionEvent event) {
        
        int clientId = Integer.parseInt(withdrawIDField.getText());
        double amount = Double.parseDouble(withdrawAmountField.getText());
        BankAccount  acc = null;
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getClient().getClientID() == clientId){
                acc = accounts.get(i);
            }
        }
        
        acc.withdraw(amount);
        
        clearWithdrawPanel();
    }

    @FXML
    private void depositButtonAction(ActionEvent event) {
        int clientId = Integer.parseInt(depositIDField.getText());
        double amount = Double.parseDouble(depositAmountField.getText());
        BankAccount acc = null;
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getClient().getClientID() == clientId){
                acc = accounts.get(i);
            }
        }
        acc.deposit(amount);
        
        clearDepositPanel();
    }
    
    public void clearAddClientPanel(){
        this.firstNameField.clear();
        this.lastNameField.clear();
        this.branchField.clear();
        this.dobBDayField.setValue(null);
        this.clientIDField.clear();
        this.contactField.clear();
        this.acTypeField.clear();
    }
    
    public void clearWithdrawPanel() {
        this.withdrawAmountField.clear();
        this.withdrawIDField.clear();
        this.withdrawPassField.clear();
    }
    
    private void clearDepositPanel() {
        this.depositContactField.clear();
        this.depositAmountField.clear();
        this.depositIDField.clear();
    }

    private void readFile() {
        clientList = FXCollections.observableArrayList();
        
        try(RandomAccessFile input = new RandomAccessFile("client.txt", "r")){
            String line;
            
            while(true){
               line = input.readLine();
               if(line == null) break;
               
               String tokens[] = line.split("\\;");
               
               int id = Integer.parseInt(tokens[0]);
               String fname = tokens[1];
               String lname = tokens[2];
               String contactNo = tokens[3];
               LocalDate dob = LocalDate.parse(tokens[4]);
               String accType = tokens[5];
               String branch = tokens[6];
               
               Name name = new Name(fname, lname);
               Client client = new Client(id, name, contactNo, dob, accType, branch);
               
               clientList.add(client);
               createAccount();
               
            }
            
        } catch(FileNotFoundException fnfe){
            System.out.println("File Not Found!!");
        } catch(IOException ex){
            System.out.println("IO Exception Occured!!");
        }
    }
    
    private void createAccount() {
        accounts = FXCollections.observableArrayList();
        BankAccount account = null;
        
        for (Client client : clientList) {
            if(client.getAccType().compareTo("Savings") == 0){
                account = new BankAccount(client, 1000);
            }
            if(client.getAccType().compareTo("Credit") == 0){
                double creditLimit = 50000.00;
                account = new CreditCard(client, creditLimit);
            }
            if(client.getAccType().compareTo("Current") == 0){
                account = new CurrentAccount(client, 1000);
            }
            
            accounts.add(account);
        }
    }
    
    private void printDetails() {

        int clientId = Integer.parseInt(detailsClientIdField.getText());
        BankAccount acc = null;
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getClient().getClientID() == clientId){
                acc = accounts.get(i);
            }
        }
        
        String name = acc.getClient().getName().toString();
        String accType = acc.getClient().getAccType();
        String balance = Double.toString(acc.getBalance());
        String contactNo = acc.getClient().getContactNo();
        
        detailsNameField.setText(name);
        detailsACTypeField.setText(accType);
        detailsBalanceField.setText(balance);
        detailsContactField.setText(contactNo);
        
        //detailsClientIdField.clear();
        
    }

    @FXML
    private void showDetailsButtonAction(ActionEvent event) {
        printDetails();
    }

    
}
