package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SystemSettingsDTO {

    @Email(message = "Podaj email")
    private String emailAddress;

    @NotBlank(message = "Podaj login")
    private String emailLogin;

    @NotBlank(message = "Podaj haslo")
    private String emailPassword;

    @NotBlank(message = "Podaj server")
    private String emailServer;

    @NotBlank(message = "Podaj protokoly")
    private String emailProtocols;

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
}
