package managers;
import entities.Applicant;
import entities.Payment;
import java.util.ArrayList;
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
        return null;
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
