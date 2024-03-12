package bigbox.example.ecommenceProject.business.abstracts;

import bigbox.example.ecommenceProject.core.utilities.results.DataResult;
import bigbox.example.ecommenceProject.core.utilities.results.Result;
import bigbox.example.ecommenceProject.entities.concretes.Product;

import javax.xml.crypto.Data;
import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<Product> getById(int id);

    DataResult<List<Product>> getByCategoryId(int id);
    DataResult<List<Product>> getBySubCategoryId(int id);
    DataResult<List<Product>> getByProductNameContains(String name);
    Result addProduct(Product product);
    Result updateProduct(Product product);
    Result deleteProduct(int id);
}
