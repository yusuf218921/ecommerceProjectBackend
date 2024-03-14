package bigbox.example.ecommenceProject.entities.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "subcategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class SubCategory {

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private int subCategoryId;
    @Column(name = "subcategory_name")
    private String subCategoryName;

    @OneToMany(mappedBy = "subCategory")
    private List<Product> products;


}
