package bigbox.example.ecommenceProject.api.controllers;

import bigbox.example.ecommenceProject.business.abstracts.ProductService;
import bigbox.example.ecommenceProject.entities.concretes.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAll(){
        return productService.getAll();
    }
}
