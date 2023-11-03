package com.cg.category;

<<<<<<< HEAD
import com.cg.category.DTO.CategoryCreReqDTO;
import com.cg.category.DTO.CategoryDTO;
import com.cg.category.DTO.CategoryUpReqDTO;
=======
import com.cg.category.DTO.*;
>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a
import com.cg.model.Category;
import com.cg.service.IGeneralService;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
public interface ICategoryService extends IGeneralService<Category,Long> {

        CategoryDTO createCategory(CategoryCreReqDTO categoryCreReqDTO);

        List<CategoryDTO> findAllCategoryDTO();

        CategoryDTO updateCategory(Long categoryId, CategoryUpReqDTO categoryUpReqDTO);

        void deleteByIdTrue(Category category);

        Optional<Category> findByIdAndDeletedFalse(Long id);

=======
public interface ICategoryService {

    CategoryCreResDTO createCategory(CategoryCreReqDTO categoryCreReqDTO);

    List<CategoryDTO> findAllCategoryDTO();

    CategoryUpResDTO updateCategory(Long categoryId, CategoryUpReqDTO categoryUpReqDTO);

    void deleteByIdTrue(Category category);

    Optional<Category> findByIdAndDeletedFalse(Long id);
>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a

}
