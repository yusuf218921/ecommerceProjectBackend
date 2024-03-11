package bigbox.example.ecommenceProject.entities.concretes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "stock_amount")
    private int stockAmount;

    public Product(int categoryId, String productName, String brandName, String productDescription, double productPrice, int stockAmount) {
        this.categoryId = categoryId;
        this.productName = productName;
        this.brandName = brandName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.stockAmount = stockAmount;
    }

    public int getProductId() {
        return productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
