package bigbox.example.ecommenceProject.business.concretes;

import bigbox.example.ecommenceProject.business.abstracts.ProductService;
import bigbox.example.ecommenceProject.dataAccess.abstracts.ProductDao;
import bigbox.example.ecommenceProject.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }
}
