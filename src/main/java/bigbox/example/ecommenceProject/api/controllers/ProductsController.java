package bigbox.example.ecommenceProject.api.controllers;

import bigbox.example.ecommenceProject.business.abstracts.ProductService;
import bigbox.example.ecommenceProject.core.utilities.results.DataResult;
import bigbox.example.ecommenceProject.core.utilities.results.Result;
import bigbox.example.ecommenceProject.entities.concretes.Product;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.EventListenerProxy;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Product> getById(@RequestParam int id){
        return productService.getById(id);
    }

    @GetMapping("/{categoryId}")
    public DataResult<List<Product>> getByCategoryId(@RequestParam int categoryId){
        return productService.getByCategoryId(categoryId);
    }

    @GetMapping("/subCategoryId")
    public DataResult<List<Product>> getBySubCategoryId(@RequestParam int subCategoryId){
        return productService.getBySubCategoryId(subCategoryId);
    }

    @GetMapping("/{productName}")
    public DataResult<List<Product>> getByProductNameContains(String name){
        return productService.getByProductNameContains(name);
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
