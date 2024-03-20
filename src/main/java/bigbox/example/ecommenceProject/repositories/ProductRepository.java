package bigbox.example.ecommenceProject.repositories;

import bigbox.example.ecommenceProject.entities.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p " +
            "WHERE p.subCategory.category.categoryId = :categoryId " +
            "AND (:minPrice IS NULL OR p.productPrice >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.productPrice <= :maxPrice) " +
            "AND (:gender IS NULL OR p.productGender = :gender)" +
            "ORDER BY CASE WHEN :orderBy = 'ASC' THEN p.productPrice END ASC, " +
            "CASE WHEN :orderBy = 'DESC' THEN p.productPrice END DESC")
    Page<Product> getBySubCategory_Category_CategoryId(int categoryId, Double minPrice, Double maxPrice, String orderBy, Short gender, Pageable pageable);

    @Query("SELECT p FROM Product p " +
            "WHERE p.subCategory.category.categoryId = :categoryId " +
            "AND p.subCategory.subCategoryId = :subCategoryId " +
            "AND (:minPrice IS NULL OR p.productPrice >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.productPrice <= :maxPrice) " +
            "AND (:gender IS NULL OR p.productGender = :gender)" +
            "ORDER BY CASE WHEN :orderBy = 'ASC' THEN p.productPrice END ASC, " +
            "CASE WHEN :orderBy = 'DESC' THEN p.productPrice END DESC")
    Page<Product> getBySubCategory_Category_CategoryIdAndSubCategory_SubCategoryId(int categoryId, int subCategoryId, Double minPrice, Double maxPrice, String orderBy, Short gender, Pageable pageable);

    @Query("SELECT p FROM Product p " +
            "WHERE (LOWER(p.productName) LIKE LOWER(concat('%', :keyword, '%')) " +
            "OR LOWER(p.productDescription) LIKE LOWER(concat('%', :keyword, '%')) " +
            "OR LOWER(p.subCategory.subCategoryName) LIKE LOWER(concat('%', :keyword, '%')) " +
            "OR LOWER(p.subCategory.category.categoryName) LIKE LOWER(concat('%', :keyword, '%'))) " +
            "AND (:minPrice IS NULL OR p.productPrice >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.productPrice <= :maxPrice) " +
            "AND (:gender IS NULL OR p.productGender = :gender)" +
            "ORDER BY CASE WHEN :orderBy = 'ASC' THEN p.productPrice END ASC, " +
            "CASE WHEN :orderBy = 'DESC' THEN p.productPrice END DESC")
    Page<Product> getByProductNameContains(String keyword, Double minPrice, Double maxPrice, String orderBy, Short gender, Pageable pageable);

    @Query("SELECT p FROM Product p " +
            "WHERE (:minPrice IS NULL OR p.productPrice >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.productPrice <= :maxPrice) " +
            "AND (:gender IS NULL OR p.productGender = :gender)" +
            "ORDER BY CASE WHEN :orderBy = 'ASC' THEN p.productPrice END ASC, " +
            "CASE WHEN :orderBy = 'DESC' THEN p.productPrice END DESC")
    Page<Product> findProductsByProductPriceRange(Double minPrice, Double maxPrice, String orderBy, Short gender, Pageable pageable);

}
