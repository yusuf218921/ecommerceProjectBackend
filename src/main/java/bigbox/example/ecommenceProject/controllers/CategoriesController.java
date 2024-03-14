package bigbox.example.ecommenceProject.controllers;

import bigbox.example.ecommenceProject.entities.entity.Category;
import bigbox.example.ecommenceProject.services.contracts.CategoryService;
import bigbox.example.ecommenceProject.utils.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoriesController {
    CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public DataResult<List<Category>> getAll(){
        return categoryService.getAllCategories();
    }
}
