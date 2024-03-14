package bigbox.example.ecommenceProject.services.contracts;

import bigbox.example.ecommenceProject.entities.dtos.StarProductDto;
import bigbox.example.ecommenceProject.utils.requests.MetaData;
import bigbox.example.ecommenceProject.utils.results.DataResult;

public interface StarProductService {
    DataResult<MetaData<StarProductDto>> getAllStarProducts(int pageSize, int pageNo);
}
