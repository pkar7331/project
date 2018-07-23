package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AttributePatternDTO {

    //@NotBlank(message = "") wywala błąd przy widoku
    private long idAttributePattern;

    @NotBlank(message = "Podaj nazwe")
    private String name;

    @NotBlank(message = "??")
    private String regex;

    @NotNull
    private boolean obligatory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public boolean isObligatory() {
        return obligatory;
    }

    public void setObligatory(boolean obligatory) {
        this.obligatory = obligatory;
    }

    public long getIdAttributePattern() {
        return idAttributePattern;
    }

    public void setIdAttributePattern(long idAttributePattern) {
        this.idAttributePattern = idAttributePattern;
    }
}
