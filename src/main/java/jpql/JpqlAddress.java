package jpql;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JpqlAddress {
    @Column(length = 20)
    private String city;
    @Column(length = 50)
    private String street;
    @Column(length = 6)
    private String zipcode;

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
