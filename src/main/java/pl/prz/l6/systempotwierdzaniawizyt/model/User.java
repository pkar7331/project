package pl.prz.l6.systempotwierdzaniawizyt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    @Column(nullable = false, name = "email")
    @Email
    private String email;
    @Column(nullable = false, name = "password")
    @Size(max = 72)
    @JsonIgnore
    private String password;
    // TODO: 16.05.2018 zmienić domyślnie aktywnego użytkownika na false
    @Column(nullable = false, name = "enabled")
    private boolean enabled = true;
    // TODO: 16.05.2018 wymagane do logowania, poprawić przy security
    @Column(name = "role", columnDefinition = "VARCHAR(255) default 'ROLE_USER'")
    private String role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_settings")
    private UserSettings userSettings;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_admin")
    private Admin admin;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
