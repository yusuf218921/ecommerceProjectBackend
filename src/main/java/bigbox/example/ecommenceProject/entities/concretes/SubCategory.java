package bigbox.example.ecommenceProject.entities.concretes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subcategory")
@Data
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private int subCategoryId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "subcategory_name")
    private String subCategoryName;

    public SubCategory(int categoryId, String subCategoryName) {
        this.categoryId = categoryId;
        this.subCategoryName = subCategoryName;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
}
