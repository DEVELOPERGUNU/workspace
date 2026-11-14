package com.substring.quiz.category.controllers;

import com.substring.quiz.category.dtos.CategoryDto;
import com.substring.quiz.category.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //create category

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory( @RequestBody CategoryDto categoryDto){


        CategoryDto category = this.categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
                                                      @PathVariable("id") String id){

        CategoryDto category = this.categoryService.updateCategory(id, categoryDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") String id){

        this.categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") String id){


        CategoryDto category = this.categoryService.getCategory(id);

        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){

        List<CategoryDto> categories = this.categoryService.getAllCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);

    }



}
