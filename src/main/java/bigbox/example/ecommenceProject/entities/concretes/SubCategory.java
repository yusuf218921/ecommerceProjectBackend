package bigbox.example.ecommenceProject.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subcategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private int subCategoryId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "subcategory_name")
    private String subCategoryName;


}
