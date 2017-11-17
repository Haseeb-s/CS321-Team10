package entities;

/**
 * This entity will store the applicant information for the sign up process
 * @author Kevin Silvera
 */

public class Applicant{
    private String name;
    private String phoneNum;
    private String userName;
    private String password;
    private String address;

    /**
     * Will construct a default applicant that can be changed from the manager side
     * according to how many applicants sign up to the system.
     */
    public Applicant(){
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
    }

    /**
     * Will grab the phone number of the current applicant
     * @return the phone number of the applicant
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Will set the phone number of the current applicant
     * @param phoneNum will get the phone number from the user
     */
    public void setPhoneNum(String phoneNum){
    }
    /**
     * Gets the username for the current applicant
     * @return the username specific to the applicant
     */
    public String getUsername(){
        return userName;
    }

    /**
     * sets the username for the current applicant if signup
     * @param userName is the user inputted userName
     */
    public void setUsername(String userName){
        this.userName = userName;
    }

    /**
     * gets the password for the current applicant
     * @return the password specific to the applicant
     */
    public String getPassword(){
        return password;
    }

    /**
     * sets the password when used in the sign up process
     * @param password will be given from the user
     */
    public void setPassword(String password){
        this.password = password;
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
