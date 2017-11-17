package entities;

/**
 * The Payment Entity will handle the saving and retrieving of payment information for a single applicant
 * @author Kevin Silvera
 */

public class Payment{
    private String creditCardNumber;
    private String expirationDate;

    /**
     * Will construct a new payment for a single applicant
     * @param creditCardNumber holds user credit card information
     * @param expirationDate holds user expiration date
     */
    public Payment(String creditCardNumber, String expirationDate){
        /* Will Create a new payment for the current applicant
         */
    }

    /**
     * Will obtain the credit card number that is specific to the applicant
     * @return the credit card number of the user
     */
    public String getCreditCardNumber() {
        return "";
    }

    /**
     * Will set the new credit card information from the user if error happens
     * @param creditCardNumber will hold the user's input on their credit card number
     */
    public void setCreditCardNumber(String creditCardNumber){
    }

    /**
     * Will get the expiration date for the applicant credit card
     * @return the expiration date for the specified user
     */
    public String getExpirationDate(){
        return "";
    }

    /**
     * Will set the credit card information from the user if error happens
     * @param expirationDate will hold the user's input for the expiration date
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}