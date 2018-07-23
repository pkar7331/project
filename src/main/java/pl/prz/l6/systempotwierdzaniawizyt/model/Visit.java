package pl.prz.l6.systempotwierdzaniawizyt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.prz.l6.systempotwierdzaniawizyt.utilities.RandomString;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @Column(name = "id_visit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVisit;
    @Column(nullable = false, name = "start")
    private Date start;
    @Column(nullable = false, name = "end")
    private Date end;
    @Column(nullable = false, name = "description")
    private String description;
    @Column(nullable = false, name = "title")
    private String title;
    @Column(nullable = false, name = "verification")
    private boolean verification;
    @Column(nullable = false, name = "completed")
    private boolean completed;
    @Column(nullable = false, name = "canceled")
    private boolean canceled;
    @Column(nullable = true, name = "token")
    private String token;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "visit", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Notification> listOfNotification;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_company")
    private Company company;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @PrePersist
    void preInsert() {
        if (this.token == null) {
            RandomString randomString = new RandomString(20);
            token = randomString.nextString();
        }
    }

    public long getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(long idVisit) {
        this.idVisit = idVisit;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Notification> getListOfNotification() {
        return listOfNotification;
    }

    public void setListOfNotification(List<Notification> listOfNotification) {
        this.listOfNotification = listOfNotification;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

