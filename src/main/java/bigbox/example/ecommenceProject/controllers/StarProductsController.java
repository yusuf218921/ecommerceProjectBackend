package bigbox.example.ecommenceProject.controllers;

import bigbox.example.ecommenceProject.entities.dtos.StarProductDto;
import bigbox.example.ecommenceProject.entities.entity.Category;
import bigbox.example.ecommenceProject.entities.entity.StarProduct;
import bigbox.example.ecommenceProject.services.contracts.CategoryService;
import bigbox.example.ecommenceProject.services.contracts.StarProductService;
import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/starproduct")
public class StarProductsController {
    StarProductService starProductService;

    @Autowired
    public StarProductsController(StarProductService starProductService) {
        this.starProductService = starProductService;
    }

    @GetMapping
    public DataResult<MetaData<StarProductDto>> getAll(
            @RequestParam(value = "pageNo",defaultValue = "0", required = false ) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10", required = false ) int pageSize){
        return starProductService.getAllStarProducts(pageSize, pageNo);
    }
}
