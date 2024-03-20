package bigbox.example.ecommenceProject.repositories;

import bigbox.example.ecommenceProject.entities.dtos.StarProductDto;
import bigbox.example.ecommenceProject.entities.entity.StarProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StarProductRepository extends JpaRepository<StarProduct, Integer> {
    @Query("SELECT new bigbox.example.ecommenceProject.entities.dtos.StarProductDto(sp.starProductId,p.productId, p.productName, p.productPrice, p.productDescription, p.productImgUrl) FROM StarProduct sp JOIN sp.product p")
    Page<StarProductDto> fetchStarProductDtos(Pageable pageable);
}
