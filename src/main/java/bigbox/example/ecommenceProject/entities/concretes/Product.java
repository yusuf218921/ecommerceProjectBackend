package bigbox.example.ecommenceProject.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "subcategory_id")
    private int subcategoryId;

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

    @Column(name = "product_img_url")
    private String productImgUrl;

    @Column(name = "status")
    private boolean status;
}
