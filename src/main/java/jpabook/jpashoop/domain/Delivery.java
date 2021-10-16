package jpabook.jpashoop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

}
