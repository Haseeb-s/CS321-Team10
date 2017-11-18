package entities;

/**
 * This entity will store the applicant information for the sign up process
 * @author Kevin Silvera
 */

public class Applicant{
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String creditCard;
    private String expirationDate;

    /**
     * Will construct a default applicant that can be changed from the manager side
     * according to how many applicants sign up to the system.
     */
    public Applicant(){
    }

    /**
     * Constructor to create a new applicant
     * @param name the name of the applicant
     * @param email the email address of the applicant
     * @param phoneNumber the phone number of the applicant
     * @param address the address of the applicant
     * @param creditCard the credit card number of the applicant
     * @param expirationDate the expiration date for the credit card
     */
    public Applicant(String name, String email, String phoneNumber,
                     String address, String creditCard, String expirationDate) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.creditCard = creditCard;
        this.expirationDate = expirationDate;

    }


    /**
     * Will grab the name of the current applicant
     * @return the name of applicant inputted by the user
     */
    public String getName(){
        return name;
    }

    /**
     * Will set the name of the current applicant
     * @param name will get the name from user input
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Will grab the phone number of the current applicant
     * @return the phone number of the applicant
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Will set the phone number of the current applicant
     * @param phoneNum will get the phone number from the user
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    /**
     * Gets the email for the current applicant
     * @return the username specific to the applicant
     */
    public String getEmail(){
        return email;
    }

    /**
     * sets the email for the current applicant if signup
     * @param email is the user inputted userName
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * gets the address for the current applicant
     * @return the address specific to the applicant
     */
    public String getAddress(){
        return address;
    }

    /**
     * Sets the address for this specified applicant
     * @param address will be given from the user
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * A String representation of the data in a format the user can read
     * @return A string of the relevant data
     */
    public String toString(){
        return "";
    }
}
