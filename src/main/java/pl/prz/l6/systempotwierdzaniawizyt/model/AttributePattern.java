package pl.prz.l6.systempotwierdzaniawizyt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attribute_pattern")
public class AttributePattern {

    @Id
    @Column(name = "id_attribute_pattern")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAttributePattern;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "regex")
    private String regex;
    @Column(nullable = false, name = "obligatory")
    private boolean obligatory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attributePattern", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Attribute> listOfAttribute;

    public long getIdAttributePattern() {
        return idAttributePattern;
    }

    public void setIdAttributePattern(long idAttributePattern) {
        this.idAttributePattern = idAttributePattern;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Attribute> getListOfAttribute() {
        return listOfAttribute;
    }

    public void setListOfAttribute(List<Attribute> listOfAttribute) {
        this.listOfAttribute = listOfAttribute;
    }
}

