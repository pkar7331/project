package pl.prz.l6.systempotwierdzaniawizyt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCustomer;
    @Column(nullable = false, name = "first_name")
    @Size(max = 64)
    private String firstName;
    @Column(nullable = false, name = "last_name")
    @Size(max = 64)
    private String lastName;
    @Column(nullable = false, name = "email")
    @Email
    private String email;
    @Column(nullable = false, name = "phone")
    private String phone;
    @Column(name = "comment")
    private String comment;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Visit> listOfVisit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Attribute> listOfAttribute;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_company")
    private Company company;



    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Visit> getListOfVisit() {
        return listOfVisit;
    }

    public void setListOfVisit(List<Visit> listOfVisit) {
        this.listOfVisit = listOfVisit;
    }

    public List<Attribute> getListOfAttribute() {
        return listOfAttribute;
    }

    public void setListOfAttribute(List<Attribute> listOfAttribute) {
        this.listOfAttribute = listOfAttribute;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
