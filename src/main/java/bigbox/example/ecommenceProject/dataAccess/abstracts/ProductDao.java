package bigbox.example.ecommenceProject.dataAccess.abstracts;

import bigbox.example.ecommenceProject.entities.concretes.Product;
import bigbox.example.ecommenceProject.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);
    Product getByProductNameAndCategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategoryId(String productName, int categoryId);
    List<Product> getByCategoryId(int categoryId);
    List<Product> getBySubCategoryId(int subcategoryId);
    List<Product> getByProductNameContains(String productName);

    @Query("From Product where productName=:productName and categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);
}
