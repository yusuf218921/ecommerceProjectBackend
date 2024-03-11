package bigbox.example.ecommenceProject.dataAccess.abstracts;

import bigbox.example.ecommenceProject.entities.concretes.StarProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarProductDao extends JpaRepository<StarProduct, Integer> {
}
