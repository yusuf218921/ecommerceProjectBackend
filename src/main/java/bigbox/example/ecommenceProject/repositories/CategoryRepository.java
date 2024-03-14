package bigbox.example.ecommenceProject.repositories;

import bigbox.example.ecommenceProject.entities.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
