package bigbox.example.ecommenceProject.dataAccess.abstracts;

import bigbox.example.ecommenceProject.entities.concretes.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer> {
}
