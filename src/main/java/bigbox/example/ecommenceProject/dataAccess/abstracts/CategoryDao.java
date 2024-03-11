package bigbox.example.ecommenceProject.dataAccess.abstracts;

import bigbox.example.ecommenceProject.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
