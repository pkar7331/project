package pl.prz.l6.systempotwierdzaniawizyt.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "super_admin")
public class SuperAdmin {

    @Id
    @Column(name = "id_super_admin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSuperAdmin;
    @Column(nullable = false, name = "email")
    @Email
    private String email;
    @Column(nullable = false, name = "password")
    @Size(max = 64)
    private String password;

    public long getIdSuperAdmin() {
        return idSuperAdmin;
    }

    public void setIdSuperAdmin(long idSuperAdmin) {
        this.idSuperAdmin = idSuperAdmin;
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
}
