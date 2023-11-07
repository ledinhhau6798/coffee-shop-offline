package com.cg.category;

<<<<<<< HEAD
import com.cg.category.dto.CategoryCreReqDTO;
import com.cg.category.dto.CategoryDTO;
=======

import com.cg.category.dto.CategoryResult;
import com.cg.category.dto.CreationCategoryParam;
import com.cg.category.dto.UpdateCategoryParam;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import com.cg.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
<<<<<<< HEAD
public class CategoryMapper  {
    public CategoryDTO toDTO(Long id, String title){
        return new CategoryDTO()
                .setId(id)
                .setTitle(title);
    }

    public Category toEntity(CategoryCreReqDTO categoryCreReqDTO) {
=======
public class CategoryMapper{

    public  Category toEntity(CreationCategoryParam dto) {
        return new Category().setTitle(dto.getTitle());
    }

    public  Category toEntity(UpdateCategoryParam dto, Long id) {
        return new Category().setId(id).setTitle(dto.getTitle());
    }


    public List<CategoryResult> toDTOList(List<Category> categoryList) {
        return categoryList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CategoryResult toDTO(Category entity) {
        return new CategoryResult()
                .setId(entity.getId())
                .setTitle(entity.getTitle());
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    }
}
