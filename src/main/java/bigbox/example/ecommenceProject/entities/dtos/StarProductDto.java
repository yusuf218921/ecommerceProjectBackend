package bigbox.example.ecommenceProject.entities.dtos;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StarProductDto {
    private int starProductId;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String productImgUrl;

}
