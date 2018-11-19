/**
 * Name: Asif Ahmed Chowdhury
 * ID: 2017100000015
 * Assignment: Banking System App Demo
 */

package banktransectionui;

/**
 *
 * @author chowdhuryasif
 */
public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String toString(){
        return String.format("%s %s", firstName, lastName);
    }
    
}
