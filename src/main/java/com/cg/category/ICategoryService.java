package com.cg.category;

<<<<<<< HEAD
import com.cg.category.DTO.CreationCategoryParam;
import com.cg.category.DTO.CategoryResult;
import com.cg.category.DTO.UpdateCategoryParam;
=======

import com.cg.category.dto.*;
import com.cg.model.Category;
import com.cg.service.IGeneralService;
>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4

import java.util.List;

public interface ICategoryService{
        List<CategoryResult> findAll();

        CategoryResult createCategory(CreationCategoryParam creationCategoryParam);



        CategoryResult updateCategory(String categoryId, UpdateCategoryParam updateCategoryParam);

        void deleteByIdTrue(String idStr);


        CategoryResult getByIdAndDeletedFalse(String categoryIdStr);
}
