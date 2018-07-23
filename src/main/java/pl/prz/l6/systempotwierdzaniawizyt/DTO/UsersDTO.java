package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import pl.prz.l6.systempotwierdzaniawizyt.validators.PasswordMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@PasswordMatches
public class UsersDTO  {

    @Email(message = "Podaj prawidlowy adres e-mail")
    private String email;
    @NotBlank(message = "Haslo nie moze byc puste")
    private String password;

    @NotBlank
    private String repeatPassword;

    private int deltaTimeNotifErr;

    private int deltaTimeNotif;

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public int getDeltaTimeNotifErr() {
        return deltaTimeNotifErr;
    }

    public void setDeltaTimeNotifErr(int deltaTimeNotifErr) {
        this.deltaTimeNotifErr = deltaTimeNotifErr;
    }

    public int getDeltaTimeNotif() {
        return deltaTimeNotif;
    }

    public void setDeltaTimeNotif(int deltaTimeNotif) {
        this.deltaTimeNotif = deltaTimeNotif;
    }
}
