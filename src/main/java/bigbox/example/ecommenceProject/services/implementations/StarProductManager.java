package bigbox.example.ecommenceProject.services.implementations;

import bigbox.example.ecommenceProject.entities.dtos.StarProductDto;
import bigbox.example.ecommenceProject.services.contracts.StarProductService;
import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.utils.results.SuccessDataResult;
import bigbox.example.ecommenceProject.repositories.StarProductRepository;
import bigbox.example.ecommenceProject.entities.entity.StarProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StarProductManager implements StarProductService {

    StarProductRepository starProductRepository;

    @Autowired
    public StarProductManager(StarProductRepository starProductDao) {
        this.starProductRepository = starProductDao;
    }

    @Override
    public DataResult<MetaData<StarProductDto>> getAllStarProducts(int pageSize, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<StarProductDto> products = starProductRepository.fetchStarProductDtos(pageable);
        MetaData<StarProductDto> metaData = new MetaData<>();
        metaData.setContent(products.getContent());
        metaData.setPageSize(products.getSize());
        metaData.setTotalPage(products.getTotalPages());
        metaData.setTotalCount(products.getTotalPages());
        metaData.setHasNext(products.hasNext());
        metaData.setHasPrevious(products.hasPrevious());
        metaData.setCurrentPage(pageNo);
        return new SuccessDataResult<>(metaData, "Ürünler Listelendi");
    }
}
