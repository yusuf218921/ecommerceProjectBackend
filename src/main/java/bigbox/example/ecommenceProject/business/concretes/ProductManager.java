package bigbox.example.ecommenceProject.business.concretes;

import bigbox.example.ecommenceProject.business.abstracts.ProductService;
import bigbox.example.ecommenceProject.core.utilities.results.*;
import bigbox.example.ecommenceProject.dataAccess.abstracts.ProductDao;
import bigbox.example.ecommenceProject.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productDao.findAll(), "Ürünler Listelendi");
    }

    @Override
    public DataResult<Product> getById(int id) {
        if (productDao.findById(id).isPresent())
            return new SuccessDataResult<>(productDao.findById(id).get());
        return new ErrorDataResult<>("Ürün Bulunamadı");
    }

    @Override
    public DataResult<List<Product>> getByCategoryId(int id) {
        return new SuccessDataResult<>(productDao.getByCategoryId(id),"Ürünler Listelendi");
    }

    @Override
    public DataResult<List<Product>> getBySubCategoryId(int id) {
        return new SuccessDataResult<>(productDao.getBySubCategoryId(id), "Ürünler Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String name) {
        return new SuccessDataResult<>(productDao.getByProductNameContains(name));
    }

    @Override
    public Result addProduct(Product product) {
        if (productDao.findById(product.getProductId()).isPresent())
            return new ErrorResult("İstanilen id'deki veri halihazırda veritabaında bulunmaktadır");
        productDao.save(product);
        return new SuccessResult("Ürün Başarıyla eklendi");
    }

    @Override
    public Result updateProduct(Product product) {
        Optional<Product> optionalProduct = productDao.findById(product.getProductId());
        if(optionalProduct.isEmpty())
            return new ErrorResult("Güncellenecek ürün bulunamadı");
        return new SuccessResult("Ürün başarıyla güncellendi");
    }

    @Override
    public Result deleteProduct(int id) {
        if (productDao.findById(id).isEmpty())
            return new ErrorResult("Ürün bulunamadı");
        productDao.deleteById(id);
        return new SuccessResult("Ürün başarıyla silindi");
    }


}
