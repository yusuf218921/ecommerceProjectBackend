package bigbox.example.ecommenceProject.controllers;

import bigbox.example.ecommenceProject.services.contracts.ProductService;
import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.utils.requests.ProductRequestParameters;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.utils.results.Result;
import bigbox.example.ecommenceProject.entities.entity.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public DataResult<MetaData<Product>> getAll(
            ProductRequestParameters requestParameters){
        return productService.getAll(requestParameters);
    }

    @GetMapping("/{id}")
    public DataResult<Product> getById(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/category/{categoryId}")
    public DataResult<MetaData<Product>> getByCategoryId(
            @PathVariable int categoryId,
            ProductRequestParameters requestParameters){
        return productService.getByCategoryId(categoryId, requestParameters);
    }

    @GetMapping("/category/{categoryId}/subcategory/{subCategoryId}")
    public DataResult<MetaData<Product>> getBySubCategoryId(
            @PathVariable int categoryId,
            @PathVariable int subCategoryId,
            ProductRequestParameters requestParameters){
        return productService.getBySubCategoryId(categoryId,subCategoryId, requestParameters);
    }

    @GetMapping("/search/{productName}")
    public DataResult<MetaData<Product>> getByProductNameContains(
            @PathVariable String productName,
            ProductRequestParameters requestParameters){
        return productService.getByProductNameContains(productName, requestParameters);
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
