package bigbox.example.ecommenceProject.controllers;

import bigbox.example.ecommenceProject.services.contracts.ProductService;
import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.utils.results.Result;
import bigbox.example.ecommenceProject.entities.entity.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public DataResult<MetaData<Product>> getAll(
            @RequestParam(value = "pageNo",defaultValue = "0", required = false ) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10", required = false ) int pageSize){
        return productService.getAll(pageSize, pageNo);
    }

    @GetMapping("/{id}")
    public DataResult<Product> getById(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/category/{categoryId}")
    public DataResult<MetaData<Product>> getByCategoryId(
            @PathVariable int categoryId,
            @RequestParam(value = "pageNo",defaultValue = "0", required = false ) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10", required = false ) int pageSize){
        return productService.getByCategoryId(categoryId, pageSize, pageNo);
    }

    @GetMapping("/category/{categoryId}/subcategory/{subCategoryId}")
    public DataResult<MetaData<Product>> getBySubCategoryId(
            @PathVariable int categoryId,
            @PathVariable int subCategoryId,
            @RequestParam(value = "pageNo",defaultValue = "0", required = false ) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10", required = false ) int pageSize){
        return productService.getBySubCategoryId(categoryId,subCategoryId, pageSize, pageNo);
    }

    @GetMapping("/search/{productName}")
    public DataResult<MetaData<Product>> getByProductNameContains(
            @PathVariable String productName,
            @RequestParam(value = "pageNo",defaultValue = "0", required = false ) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10", required = false ) int pageSize){
        return productService.getByProductNameContains(productName, pageSize, pageNo);
    }

    @PostMapping()
    public Result addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping()
    public Result deleteProduct(int id){
        return productService.deleteProduct(id);
    }


}
