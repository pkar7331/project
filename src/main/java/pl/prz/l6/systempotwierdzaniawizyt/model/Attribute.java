package pl.prz.l6.systempotwierdzaniawizyt.model;

import javax.persistence.*;

@Entity
@Table(name = "attribute")
public class Attribute {

    @Id
    @Column(name = "id_attribute")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAttribute;
    @Column(nullable = false, name = "value")
    private String value;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_attribute_pattern")
    private AttributePattern attributePattern;

    public long getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(long idAttribute) {
        this.idAttribute = idAttribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AttributePattern getAttributePattern() {
        return attributePattern;
    }

    public void setAttributePattern(AttributePattern attributePattern) {
        this.attributePattern = attributePattern;
    }


}
