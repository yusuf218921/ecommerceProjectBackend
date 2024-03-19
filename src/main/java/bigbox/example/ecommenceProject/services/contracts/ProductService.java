package bigbox.example.ecommenceProject.services.contracts;

import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.utils.requests.ProductRequestParameters;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.utils.results.Result;
import bigbox.example.ecommenceProject.entities.entity.Product;

public interface ProductService {
    DataResult<MetaData<Product>> getAll(ProductRequestParameters requestParameters);
    DataResult<Product> getById(int id);

    DataResult<MetaData<Product>> getByCategoryId(int id, ProductRequestParameters requestParameters);
    DataResult<MetaData<Product>> getBySubCategoryId(int categoryId,int subCategoryId, ProductRequestParameters requestParameters);
    DataResult<MetaData<Product>> getByProductNameContains(String name, ProductRequestParameters requestParameters);
    Result addProduct(Product product);
    Result updateProduct(Product product);
    Result deleteProduct(int id);
}
