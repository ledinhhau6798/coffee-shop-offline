package com.cg.category;

import com.cg.category.dto.*;
import com.cg.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    CategoryCreResDTO createCategory(CategoryCreReqDTO categoryCreReqDTO);

    List<CategoryDTO> findAllCategoryDTO();

    CategoryUpResDTO updateCategory(Long categoryId, CategoryUpReqDTO categoryUpReqDTO);

    void deleteByIdTrue(Category category);

    Optional<Category> findByIdAndDeletedFalse(Long id);

}
