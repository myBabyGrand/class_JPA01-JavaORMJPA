package jpql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JPQL_PRODUCT")
public class JpqlProduct {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long Id;
    private String name;
    private int price;
    private int stockAmount;

    @OneToMany(mappedBy = "product")
    private List<JpqlOrder> orders = new ArrayList<>();


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public List<JpqlOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<JpqlOrder> orders) {
        this.orders = orders;
    }
}
