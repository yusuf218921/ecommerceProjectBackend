package bigbox.example.ecommenceProject.services.implementations;

import bigbox.example.ecommenceProject.services.contracts.SubCategoryService;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import bigbox.example.ecommenceProject.utils.results.SuccessDataResult;
import bigbox.example.ecommenceProject.repositories.SubCategoryRepository;
import bigbox.example.ecommenceProject.entities.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryManager implements SubCategoryService {
    SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryManager(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public DataResult<List<SubCategory>> getAllSubCategories() {
        return new SuccessDataResult<>(subCategoryRepository.findAll());
    }
}
