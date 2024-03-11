package bigbox.example.ecommenceProject.entities.concretes;

import jakarta.persistence.*;

@Entity
@Table
public class StarProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "starproduct_id")
    private int starProductId;
    @Column(name = "product_id")
    private int productId;

    public StarProduct(int productId) {
        this.productId = productId;
    }

    public int getStarProductId() {
        return starProductId;
    }

    public void setStarProductId(int starProductId) {
        this.starProductId = starProductId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
