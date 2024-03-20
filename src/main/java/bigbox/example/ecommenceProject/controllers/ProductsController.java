package bigbox.example.ecommenceProject.controllers;

import bigbox.example.ecommenceProject.services.contracts.ProductService;
import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.utils.requests.ProductRequestParameters;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.utils.results.Result;
import bigbox.example.ecommenceProject.entities.entity.Product;
import jakarta.websocket.server.PathParam;
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
            @RequestParam(value = "orderBy", required = false) String orderBy,
            @RequestParam(value = "minPrice", required = false, defaultValue = "0") Double minPrice,
            @RequestParam(value = "maxPrice", required = false, defaultValue = "100000") Double maxPrice,
            @RequestParam(value = "gender", required = false) Short gender,
            @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize){
        ProductRequestParameters requestParameters = new ProductRequestParameters(orderBy,minPrice,maxPrice,gender,pageSize,pageNo);
        return productService.getAll(requestParameters);
    }

    @GetMapping("/{id}")
    public DataResult<Product> getById(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/category/{categoryId}")
    public DataResult<MetaData<Product>> getByCategoryId(
            @PathVariable int categoryId,
            @RequestParam(value = "orderBy", required = false) String orderBy,
            @RequestParam(value = "minPrice", required = false, defaultValue = "0") Double minPrice,
            @RequestParam(value = "maxPrice", required = false, defaultValue = "100000") Double maxPrice,
            @RequestParam(value = "gender", required = false) Short gender,
            @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize){
        ProductRequestParameters requestParameters = new ProductRequestParameters(orderBy,minPrice,maxPrice,gender,pageSize,pageNo);
        return productService.getByCategoryId(categoryId, requestParameters);
    }

    @GetMapping("/category/{categoryId}/subcategory/{subCategoryId}")
    public DataResult<MetaData<Product>> getBySubCategoryId(
            @PathVariable int categoryId,
            @PathVariable int subCategoryId,
            @RequestParam(value = "orderBy", required = false) String orderBy,
            @RequestParam(value = "minPrice", required = false, defaultValue = "0") Double minPrice,
            @RequestParam(value = "maxPrice", required = false, defaultValue = "100000") Double maxPrice,
            @RequestParam(value = "gender", required = false) Short gender,
            @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize){
        ProductRequestParameters requestParameters = new ProductRequestParameters(orderBy,minPrice,maxPrice,gender,pageSize,pageNo);
        return productService.getBySubCategoryId(categoryId,subCategoryId, requestParameters);
    }

    @GetMapping("/search/{productName}")
    public DataResult<MetaData<Product>> getByProductNameContains(
            @PathVariable String productName,
            @RequestParam(value = "orderBy", required = false) String orderBy,
            @RequestParam(value = "minPrice", required = false, defaultValue = "0") Double minPrice,
            @RequestParam(value = "maxPrice", required = false, defaultValue = "100000") Double maxPrice,
            @RequestParam(value = "gender", required = false) Short gender,
            @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize){
        ProductRequestParameters requestParameters = new ProductRequestParameters(orderBy,minPrice,maxPrice,gender,pageSize,pageNo);
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
