package managers;
import entities.Applicant;
import entities.Payment;
import java.util.ArrayList;

/**
 * The sign up manager will deal with the sign up process of the system and hold the applicants of
 * the system
 * @author Kevin Silvera
 */
public class SignUpManager {
    ArrayList<Applicant> applicants = new ArrayList<>();
    Applicant currentApplicant;
    Payment payment;
    private boolean paid;

    /**
     * Will return the specified applicant through email back to the system
     * @param email is email of the applicant
     * @return the specified applicant information
     */
    public Applicant getApplicantData(String email){
        //Will go through the arrayList of applicants
        //Then if an email matches then return all that applicant's data
        //if not then return null
        for(Applicant currentApplicant : applicants){
            if(currentApplicant.getEmail().equals(email))
                return currentApplicant;
        }
        return null;
    }

    /**
     * Adds a new applicant to the system
     * @param name the applicant name
     * @param email the applicant email address
     * @param phone the applicant phone number
     * @param address the applicant address
     * @param creditCard the applicant credit cart
     * @param expirationDate the expiration date
     * @return returns an applicant instance
     */
    public void addApplicant(String name, String email, String phone,
                                  String address, String creditCard, String expirationDate) {

        String error = "==================SIGN UP FAILURE==================\n" +
                "User exists with given email address\n";

        // CHECK IF APPLICANT EXISTS
        for (Applicant applicant : applicants) {
            //System.out.println(applicant.getEmail());
            if (applicant.getEmail().equals(email)) {
                System.out.println(error);
                return;
            } // END IF
        } //

        // IF APPLICANT DOES NOT EXISIT CREATE NEW APPLICANT
        Applicant applicant = new Applicant(name, email, phone,
                address, creditCard, expirationDate);
        applicants.add(applicant);

        String success = String.format(" ==================SIGN UP SUCCESS==================\n" +
                "User successfully signed up with following information:\n" +
                "Name: %s\n" +
                "Email: %s\n" +
                "Phone no: %s\n" +
                "Address: %s\n" +
                "Credit card: %s\n" +
                "Expiration date: %s\n", name, email, phone,
                address, creditCard, expirationDate);
        System.out.println(success);
        //return applicant;
    }

    /**
     * Will check to see if there is an Applicant of the same email in the system.
     * @param email email that will be used to compare
     * @return a boolean that will indicate if found or not
     */
    public boolean checkApplicants(String email){
        //Will go through the arrayList of applicants
        //Then compare the emails to see if there is a match
        //IF there is return true,
        //otherwise return false
        return false;
    }

    /**
     * Will process the payment for a single applicant then change the paid boolean
     * @param credit will be the credit card that is given
     * @param exp will be the expiration date given
     * @return true if the payment is passed otherwise false
     */
    public boolean processPayment(String credit, String exp){
        //Create a payment instance that will hold the given credit card and expiration date
        //If a successful payment happens then return true and save payment information in payment
        //else return false
        return false;
    }

}
