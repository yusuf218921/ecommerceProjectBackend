package bigbox.example.ecommenceProject.entities.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "starproduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "starproduct_id")
    private int starProductId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
