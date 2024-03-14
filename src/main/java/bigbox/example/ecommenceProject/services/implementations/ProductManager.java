package bigbox.example.ecommenceProject.services.implementations;

import bigbox.example.ecommenceProject.utils.results.*;
import bigbox.example.ecommenceProject.services.contracts.ProductService;
import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.repositories.ProductRepository;
import bigbox.example.ecommenceProject.entities.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DataResult<MetaData<Product>> getAll(int pageSize, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productRepository.findAll(pageable);
        MetaData<Product> metaData = new MetaData<>();
        metaData.setContent(products.getContent());
        metaData.setPageSize(products.getSize());
        metaData.setTotalPage(products.getTotalPages());
        metaData.setTotalCount(products.getTotalPages());
        metaData.setHasNext(products.hasNext());
        metaData.setHasPrevious(products.hasPrevious());
        metaData.setCurrentPage(pageNo);
        return new SuccessDataResult<>(metaData, "Ürünler Listelendi");
    }

    @Override
    public DataResult<Product> getById(int id) {
        if (productRepository.findById(id).isPresent())
            return new SuccessDataResult<>(productRepository.findById(id).get());
        return new ErrorDataResult<>("Ürün Bulunamadı");
    }

    @Override
    public DataResult<MetaData<Product>> getByCategoryId(int id, int pageSize, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productRepository.getBySubCategory_Category_CategoryId(id,pageable);
        MetaData<Product> metaData = new MetaData<>();
        metaData.setContent(products.getContent());
        metaData.setPageSize(products.getSize());
        metaData.setTotalPage(products.getTotalPages());
        metaData.setTotalCount(products.getTotalPages());
        metaData.setHasNext(products.hasNext());
        metaData.setHasPrevious(products.hasPrevious());
        metaData.setCurrentPage(pageNo);
        return new SuccessDataResult<>(metaData,"Ürünler Listelendi");
    }

    @Override
    public DataResult<MetaData<Product>> getBySubCategoryId(int categoryId,int subCategoryId, int pageSize, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productRepository.getBySubCategory_Category_CategoryIdAndSubCategory_SubCategoryId(categoryId,subCategoryId,pageable);
        MetaData<Product> metaData = new MetaData<>();
        metaData.setContent(products.getContent());
        metaData.setPageSize(products.getSize());
        metaData.setTotalPage(products.getTotalPages());
        metaData.setTotalCount(products.getTotalPages());
        metaData.setHasNext(products.hasNext());
        metaData.setHasPrevious(products.hasPrevious());
        metaData.setCurrentPage(pageNo);
        return new SuccessDataResult<>(metaData);
    }

    @Override
    public DataResult<MetaData<Product>> getByProductNameContains(String name, int pageSize, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productRepository.getByProductNameContains(name,pageable);
        MetaData<Product> metaData = new MetaData<>();
        metaData.setContent(products.getContent());
        metaData.setPageSize(products.getSize());
        metaData.setTotalPage(products.getTotalPages());
        metaData.setTotalCount(products.getTotalPages());
        metaData.setHasNext(products.hasNext());
        metaData.setHasPrevious(products.hasPrevious());
        metaData.setCurrentPage(pageNo);
        return new SuccessDataResult<>(metaData);
    }

    @Override
    public Result addProduct(Product product) {
        if (productRepository.findById(product.getProductId()).isPresent())
            return new ErrorResult("İstanilen id'deki veri halihazırda veritabaında bulunmaktadır");
        productRepository.save(product);
        return new SuccessResult("Ürün Başarıyla eklendi");
    }

    @Override
    public Result updateProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
        if(optionalProduct.isEmpty())
            return new ErrorResult("Güncellenecek ürün bulunamadı");
        return new SuccessResult("Ürün başarıyla güncellendi");
    }

    @Override
    public Result deleteProduct(int id) {
        if (productRepository.findById(id).isEmpty())
            return new ErrorResult("Ürün bulunamadı");
        productRepository.deleteById(id);
        return new SuccessResult("Ürün başarıyla silindi");
    }


}
