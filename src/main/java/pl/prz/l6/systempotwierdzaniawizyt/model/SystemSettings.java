package pl.prz.l6.systempotwierdzaniawizyt.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "system_settings")
public class SystemSettings {

    @Id
    @Column(name = "id_system_settings")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSystemSettings;
    @Email
    @Column(nullable = false, name = "email_address")
    @Size(max = 64)
    private String emailAddress;
    @Column(nullable = false, name = "email_login")
    @Size(max = 64)
    private String emailLogin;
    @Column(nullable = false, name = "email_password")
    @Size(max = 64)
    private String emailPassword;
    @Column(nullable = false, name = "email_server")
    @Size(max = 64)
    private String emailServer;
    @Column(nullable = false, name = "email_protocols")
    @Size(max = 64)
    private String emailProtocols;
    @Column(nullable = false, name = "activated")
    private boolean activated;

    public long getIdSystemSettings() {
        return idSystemSettings;
    }

    public void setIdSystemSettings(long idSystemSettings) {
        this.idSystemSettings = idSystemSettings;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

    public String getEmailProtocols() {
        return emailProtocols;
    }

    public void setEmailProtocols(String emailProtocols) {
        this.emailProtocols = emailProtocols;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
