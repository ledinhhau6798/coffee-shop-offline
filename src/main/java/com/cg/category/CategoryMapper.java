package com.cg.category;


import com.cg.category.dto.CategoryResult;
import com.cg.category.dto.CreationCategoryParam;
import com.cg.category.dto.UpdateCategoryParam;
import com.cg.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
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
    }
}
