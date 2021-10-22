package jpql;

import jpabook.jpashoop.domain.Member;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "JPQL_ORDER")
public class JpqlOrder {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private JpqlMember member;

    private int orderAmount;

    @Embedded
    private JpqlAddress address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private JpqlProduct product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JpqlMember getMember() {
        return member;
    }

    public void setMember(JpqlMember member) {
        this.member = member;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public JpqlAddress getAddress() {
        return address;
    }

    public void setAddress(JpqlAddress address) {
        this.address = address;
    }

    public JpqlProduct getProduct() {
        return product;
    }

    public void setProduct(JpqlProduct product) {
        this.product = product;
    }
}
