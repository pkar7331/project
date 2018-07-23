package pl.prz.l6.systempotwierdzaniawizyt.DTO;


import pl.prz.l6.systempotwierdzaniawizyt.validators.PasswordMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@PasswordMatches
public class AdminDTO implements UserDTO {

    private long adminId;

    @Email(message = "Podaj prawidlowy adres e-mail")
    private String email;
    @NotBlank(message = "Haslo nie moze byc puste")
    private String password;
    @NotBlank
    private String repeatPassword;

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRepeatPassword() {
        return repeatPassword;
    }

    @Override
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
