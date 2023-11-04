package com.cg.category;

<<<<<<< HEAD
import com.cg.category.DTO.CategoryCreReqDTO;
import com.cg.category.DTO.CategoryCreResDTO;
import com.cg.category.DTO.CategoryDTO;
import com.cg.category.DTO.CategoryUpReqDTO;
=======
import com.cg.category.dto.*;
>>>>>>> Tuan
import com.cg.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService extends IGeneralService<Category,Long> {

        CategoryCreResDTO createCategory(CategoryCreReqDTO categoryCreReqDTO);

        List<CategoryDTO> findAllCategoryDTO();

        CategoryDTO updateCategory(Long categoryId, CategoryUpReqDTO categoryUpReqDTO);

        void deleteByIdTrue(Category category);

        Optional<Category> findByIdAndDeletedFalse(Long id);

}
