package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import javax.validation.constraints.NotBlank;



public class AttributeDTO {

    @NotBlank(message = "")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
