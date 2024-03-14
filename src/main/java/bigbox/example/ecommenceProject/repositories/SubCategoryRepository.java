package bigbox.example.ecommenceProject.repositories;

import bigbox.example.ecommenceProject.entities.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
}
