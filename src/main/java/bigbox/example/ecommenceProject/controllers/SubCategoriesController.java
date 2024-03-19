package bigbox.example.ecommenceProject.controllers;

import bigbox.example.ecommenceProject.entities.entity.Category;
import bigbox.example.ecommenceProject.entities.entity.SubCategory;
import bigbox.example.ecommenceProject.services.contracts.CategoryService;
import bigbox.example.ecommenceProject.services.contracts.SubCategoryService;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
@CrossOrigin(origins = "http://localhost:5173/")
public class SubCategoriesController {
    SubCategoryService subCategoryService;

    @Autowired
    public SubCategoriesController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping
    public DataResult<List<SubCategory>> getAll(){
        return subCategoryService.getAllSubCategories();
    }

    @GetMapping("/popular")
    public DataResult<List<SubCategory>> getAllPopular(){
        return subCategoryService.getAllSubCategoriesPopular();
    }
}
