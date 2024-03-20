package bigbox.example.ecommenceProject.utils.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestParameters {
    private String orderBy;
    private double minPrice;
    private double maxPrice;
    private Short gender;
    private int pageSize;
    private int pageNo;

    public ProductRequestParameters(String orderBy, double minPrice, double maxPrice,Short gender, int pageSize, int pageNo) {
        this.orderBy = orderBy;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.gender = gender;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }
}
