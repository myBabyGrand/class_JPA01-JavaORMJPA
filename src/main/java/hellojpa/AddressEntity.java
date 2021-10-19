package hellojpa;

import javax.persistence.*;

@Entity
@Table(name= "ADDRESS_OLD")
public class AddressEntity {

    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

    public AddressEntity(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public AddressEntity() {
    }

    private String city;
    private String street;
    private String zipcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
