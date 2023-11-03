package com.cg.category;

import com.cg.category.DTO.CategoryCreReqDTO;
import com.cg.category.DTO.CategoryDTO;
import com.cg.category.DTO.CategoryUpReqDTO;
import com.cg.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public CategoryDTO createCategory(CategoryCreReqDTO dto) {
        Category category = dto.toDTO();
        categoryRepository.save(category);
        return category.toDTO(category.getId(), category.getTitle());
    }

    @Override
    public List<CategoryDTO> findAllCategoryDTO() {
        return categoryRepository.findAll().stream().map(category -> new Category().toDTO(category.getId(),category.getTitle())).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryUpReqDTO categoryUpReqDTO) {
        Category category = categoryUpReqDTO.toCategoryUpreqDTO(categoryId);
        categoryRepository.save(category);
        return new Category().toDTO(categoryId, categoryUpReqDTO.getTitle());
    }

    @Override
    public void deleteByIdTrue(Category category) {
        category.setDeleted(true);
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findByIdAndDeletedFalse(Long id) {
        return categoryRepository.findByIdAndDeletedFalse(id);
    }


}
