package bigbox.example.ecommenceProject.utils.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequestParameters {
    private String orderBy;
    private double minPrice = 0;
    private double maxPrice = 100000;
    private int pageSize = 10;
    private int pageNo = 0;

    public ProductRequestParameters(String orderBy, double minPrice, double maxPrice, int pageSize, int pageNo) {
        this.orderBy = orderBy;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

}
