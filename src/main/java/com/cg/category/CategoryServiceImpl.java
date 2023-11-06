package com.cg.category;

import com.cg.category.DTO.CreationCategoryParam;
import com.cg.category.DTO.CategoryResult;
import com.cg.category.DTO.UpdateCategoryParam;
import com.cg.exception.DataInputException;
import com.cg.model.Category;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;
    private final ValidateUtils validateUtils;


    private final AppUtils appUtils;


    @Override
    @Transactional
    public CategoryResult createCategory(CreationCategoryParam dto) {

        Category entity = categoryMapper.toEntity(dto);
        categoryRepository.save(entity);

        return categoryMapper.toDTO(entity);
    }



    @Override
    @Transactional
    public CategoryResult updateCategory(String categoryIdStr, UpdateCategoryParam updateCategoryParam) {
        if (!validateUtils.isNumberValid(categoryIdStr)){
            throw new DataInputException("Mã không hợp lệ");
        }

        Long idCategory =Long.parseLong(categoryIdStr);
        categoryRepository.findByIdAndDeletedFalse(idCategory).orElseThrow(() ->{
            throw new DataInputException("Mã không tồn tại");
        });
        Category category = categoryMapper.toEntity(updateCategoryParam,idCategory);
        categoryRepository.save(category);

        return categoryMapper.toDTO(category);
    }


    @Override
    @Transactional
    public void deleteByIdTrue(String idStr) {
        if (!validateUtils.isNumberValid(idStr)) {
            throw new DataInputException("Mã không hợp lệ");
        }
        Long categoryId = Long.parseLong(idStr);
        Category category = categoryRepository.findByIdAndDeletedFalse(categoryId).orElseThrow(() -> {
            throw new DataInputException("Mã không tồn tại ");
        });
        category.setDeleted(true);
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public CategoryResult getByIdAndDeletedFalse(String categoryIdStr) {

        if (!validateUtils.isNumberValid(categoryIdStr)) {
            throw new DataInputException("Mã danh mục không hợp lệ");
        }
        Long categoryId = Long.parseLong(categoryIdStr);
        Category entity = categoryRepository.getByIdAndDeletedFalse(categoryId);
         return categoryMapper.toDTO(entity);
    }

    public boolean existById(Long id) {
        return categoryRepository.existsById(id);
    }


    @Override
    @Transactional
    public List<CategoryResult> findAll() {
      List<Category> categoryList = categoryRepository.findAll();
      return categoryMapper.toDTOList(categoryList);
    }


}
