package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import pl.prz.l6.systempotwierdzaniawizyt.model.Customer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;


public class VisitDTO {

    private long idVisit;

    @NotBlank
    private String title;

    @NotNull(message ="Podaj czas rozpoczęcia wizyty")
    private String start;

    @NotNull(message ="Podaj czas zakonczenia wizyty")
    private String end;

    @NotBlank(message ="Podaj informacje o wizycie")
    private String description;

    private long idEmployee;

    private boolean completed;

    private boolean canceled;

    private boolean verification;

    private String idCustomer;

    public long getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(long idVisit) {
        this.idVisit = idVisit;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean isVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }
}
