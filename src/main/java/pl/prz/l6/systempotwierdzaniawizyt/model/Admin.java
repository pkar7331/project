package pl.prz.l6.systempotwierdzaniawizyt.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "id_admin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdmin;
    @Column(nullable = false, name = "email")
    @Email
    private String email;
    @Column(nullable = false, name = "password")
    @Size(max = 64)
    private String password;
    // TODO: zmienić domyślnie aktywnego użytkownika na false
    private boolean enabled = true;
    // TODO: wymagane do logowania, poprawić przy security
    @Column(name = "role", columnDefinition = "VARCHAR(255) default 'ROLE_ADMIN'")
    private String role;
    @Column(nullable = true, name = "token")
    @Size(max = 64)
    private String token;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "admin", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<User> listOfUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "admin", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Company> listOfCompany;

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getListOfUser() {
        return listOfUser;
    }

    public void setListOfUser(List<User> listOfUser) {
        this.listOfUser = listOfUser;
    }

    public List<Company> getListOfCompany() {
        return listOfCompany;
    }

    public void setListOfCompany(List<Company> listOfCompany) {
        this.listOfCompany = listOfCompany;
    }
}