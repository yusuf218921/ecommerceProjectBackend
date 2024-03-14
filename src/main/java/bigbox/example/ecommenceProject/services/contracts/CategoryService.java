package bigbox.example.ecommenceProject.services.contracts;

import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.entities.entity.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAllCategories();
}
