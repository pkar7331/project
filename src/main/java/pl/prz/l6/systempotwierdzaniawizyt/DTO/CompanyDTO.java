package pl.prz.l6.systempotwierdzaniawizyt.DTO;

import javax.validation.constraints.NotBlank;

public class CompanyDTO {

    @NotBlank(message = "City field is required!")
    private String city;//

    @NotBlank(message = "Descriptionfield is required!")
    private String description;//

    @NotBlank(message = "Flat Number field is required!")
    private String flatNumber;//

    @NotBlank(message = "Name field is required!")
    private String name;//

    @NotBlank(message = "Post Code field is required!")
    private String postCode;

    @NotBlank(message = "Street field is required!")
    private String street;//

    @NotBlank(message = "Phone number field is required!")
    private String phoneNumber;//

    private long companyId;

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
