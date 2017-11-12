package entities;

import java.time.LocalDateTime;

public class Application {
    private String resume;
    private String coverLetter;
    private String status;
    private LocalDateTime dateApplied;
    private LocalDateTime dateWithdrawn;

    public Application() {
        dateApplied = LocalDateTime.now();
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }


    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getCoverLetter() {
        return coverLetter;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public string getStatus() {
        return status;
    }

    public LocalDateTime getDateApplied() {
        return dateApplied;
    }

    public void withdrawApplication() {
        dateWithdrawn = LocalDateTime.now();
    }


    public String toString() {
        return "Status: " + status + " Date Applied : " + dateApplied;
    }


}