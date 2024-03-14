package bigbox.example.ecommenceProject.services.contracts;

import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.entities.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {
    DataResult<List<SubCategory>> getAllSubCategories();
}
