package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import javax.validation.constraints.NotBlank;


public class EmployeeDTO {

    private long Id;

    @NotBlank(message = "Podaj imie przeprowadzajacego")
    private String firstName;

    private String lastName;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName;  }
}

