package bigbox.example.ecommenceProject.dataAccess.abstracts;

import bigbox.example.ecommenceProject.entities.concretes.Product;
import bigbox.example.ecommenceProject.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
