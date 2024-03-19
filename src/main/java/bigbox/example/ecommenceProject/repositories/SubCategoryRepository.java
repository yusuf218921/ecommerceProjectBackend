package bigbox.example.ecommenceProject.repositories;

import bigbox.example.ecommenceProject.entities.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    List<SubCategory> getByIsPopular(boolean isPopular);
}
