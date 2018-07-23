package pl.prz.l6.systempotwierdzaniawizyt.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id_employee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmployee;
    @Column(nullable = false, name = "first_name")
    @Size(max = 64)
    private String firstName;
    @Column(nullable = false, name = "last_name")
    @Size(max = 64)
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Visit> listOfVisit;

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Visit> getListOfVisit() {
        return listOfVisit;
    }

    public void setListOfVisit(List<Visit> listOfVisit) {
        this.listOfVisit = listOfVisit;
    }
}
