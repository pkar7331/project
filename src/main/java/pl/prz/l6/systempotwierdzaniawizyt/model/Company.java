package pl.prz.l6.systempotwierdzaniawizyt.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "id_company")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompany;
    @Column(nullable = false, name = "name")
    @Size(max = 64)
    private String name;
    @Column(nullable = false, name = "street")
    @Size(max = 64)
    private String street;
    @Column(nullable = false, name = "flat_number")
    @Size(max = 64)
    private String flatNumber;
    @Column(nullable = false, name = "city")
    @Size(max = 64)
    private String city;
    @Column(nullable = false, name = "post_code")
    @Size(max = 64)
    private String postCode;
    @Column(nullable = false, name = "phone")
    @Size(max = 64)
    private String phone;
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<User> listOfUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Visit> listOfVisit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<AttributePattern> listOfAttributePattern;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Employee> listOfEmployee;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Customer> listOfCustomer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_admin")
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getListOfUser() {
        return listOfUser;
    }

    public void setListOfUser(List<User> listOfUser) {
        this.listOfUser = listOfUser;
    }

    public List<Visit> getListOfVisit() {
        return listOfVisit;
    }

    public void setListOfVisit(List<Visit> listOfVisit) {
        this.listOfVisit = listOfVisit;
    }

    public List<AttributePattern> getListOfAttributePattern() {
        return listOfAttributePattern;
    }

    public void setListOfAttributePattern(List<AttributePattern> listOfAttributePattern) {
        this.listOfAttributePattern = listOfAttributePattern;
    }

    public List<Employee> getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(List<Employee> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public List<Customer> getListOfCustomer() {
        return listOfCustomer;
    }

    public void setListOfCustomer(List<Customer> listOfCustomer) {
        this.listOfCustomer = listOfCustomer;
    }
}
