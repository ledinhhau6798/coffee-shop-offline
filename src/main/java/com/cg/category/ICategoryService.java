package com.cg.category;

import com.cg.category.DTO.CreationCategoryParam;
import com.cg.category.DTO.CategoryResult;
import com.cg.category.DTO.UpdateCategoryParam;

import java.util.List;

public interface ICategoryService{
        List<CategoryResult> findAll();

        CategoryResult createCategory(CreationCategoryParam creationCategoryParam);



        CategoryResult updateCategory(String categoryId, UpdateCategoryParam updateCategoryParam);

        void deleteByIdTrue(String idStr);


        CategoryResult getByIdAndDeletedFalse(String categoryIdStr);
}
