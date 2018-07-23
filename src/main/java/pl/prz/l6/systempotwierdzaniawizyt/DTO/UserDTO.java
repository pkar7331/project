package pl.prz.l6.systempotwierdzaniawizyt.DTO;

public interface UserDTO {
    String getEmail();
    void setEmail(String emial);
    String getPassword();
    void setPassword(String password);
    String getRepeatPassword();
    void setRepeatPassword(String password);
}
