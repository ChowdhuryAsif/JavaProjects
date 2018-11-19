/**
 * Name: Asif Ahmed Chowdhury
 * ID: 2017100000015
 * Assignment: Banking System App Demo
 */

package banktransectionui;

import java.time.LocalDate;

/**
 *
 * @author chowdhuryasif
 */
public class Client {
    private int clientID;
    private Name name;
    private String contactNo;
    private LocalDate dob;
    private String accType;
    private String branch;

    public Client(int clientID, Name name, String contactNo, LocalDate dob, String accType, String branch) {
        this.clientID = clientID;
        this.name = name;
        this.contactNo = contactNo;
        this.dob = dob;
        this.accType = accType;
        this.branch = branch;
    }

    public int getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getAccType() {
        return accType;
    }

    public String getBranch() {
        return branch;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    
    public String toString() {
        return String.format("%d;%s;%s;%s;%s;%s;%s",
                clientID,
                name.getFirstName(),
                name.getLastName(),
                contactNo,
                dob,
                accType,
                branch
                );
    }
}
