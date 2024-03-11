package bigbox.example.ecommenceProject.business.abstracts;

import bigbox.example.ecommenceProject.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
