package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import javax.validation.constraints.NotBlank;


public class NotificationTemplateDTO {

    @NotBlank(message = "Podaj nazwe szablonu")
    private String name;

    @NotBlank(message = "Wypelnij tresc")
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
