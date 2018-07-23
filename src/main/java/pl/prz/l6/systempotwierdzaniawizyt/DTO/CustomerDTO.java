package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



public class CustomerDTO {

    private long customerId;

    @NotBlank(message = "Podaj imie")
    private String firstName;

    @NotBlank(message = "Podaj nazwisko")
    private String lastName;

    @Email(message = "Podaj prawidlowy adres e-mail")
    private String email;

    @NotBlank(message ="Podaj numer telefonu")
    private String phone;

    private String comment;


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(){
        this.comment = comment;
    }


}
