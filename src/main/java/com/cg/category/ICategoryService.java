package com.cg.category;



import com.cg.category.dto.*;


import java.util.List;

public interface ICategoryService{
        List<CategoryResult> findAll();

        CategoryResult createCategory(CreationCategoryParam creationCategoryParam);



        CategoryResult updateCategory(String categoryId, UpdateCategoryParam updateCategoryParam);

        void deleteByIdTrue(String idStr);


        CategoryResult getByIdAndDeletedFalse(String categoryIdStr);
}
