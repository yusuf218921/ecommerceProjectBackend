package bigbox.example.ecommenceProject.services.contracts;

import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.utils.results.Result;
import bigbox.example.ecommenceProject.entities.entity.Product;

public interface ProductService {
    DataResult<MetaData<Product>> getAll(int pageSize, int pageNo);
    DataResult<Product> getById(int id);

    DataResult<MetaData<Product>> getByCategoryId(int id, int pageSize, int pageNo);
    DataResult<MetaData<Product>> getBySubCategoryId(int categoryId,int subCategoryId, int pageSize, int pageNo);
    DataResult<MetaData<Product>> getByProductNameContains(String name, int pageSize, int pageNo);
    Result addProduct(Product product);
    Result updateProduct(Product product);
    Result deleteProduct(int id);
}
