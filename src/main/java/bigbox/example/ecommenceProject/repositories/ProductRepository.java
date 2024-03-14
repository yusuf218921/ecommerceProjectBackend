package bigbox.example.ecommenceProject.repositories;

import bigbox.example.ecommenceProject.entities.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> getBySubCategory_Category_CategoryId(int categoryId, Pageable pageable);
    Page<Product> getBySubCategory_Category_CategoryIdAndSubCategory_SubCategoryId(int categoryId, int subCategoryId, Pageable pageable);
    Page<Product> getByProductNameContains(String productName, Pageable pageable);

}
