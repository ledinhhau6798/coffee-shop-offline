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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryCreReqMapper categoryCreReqMapper;
    private final CategoryCreResMapper categoryCreResMapper;
    private final CategoryUpReqMapper categoryUpReqMapper;
    private final CategoryUpResMapper categoryUpResMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public CategoryCreResDTO createCategory(CategoryCreReqDTO categoryCreReqDTO) {

        Category category = categoryCreReqMapper.toEntity(categoryCreReqDTO);
        categoryRepository.save(category);

        return categoryCreResMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> findAllCategoryDTO() {
        return categoryRepository.findAll().stream().map(category -> new Category().toDTO(category.getId(), category.getTitle())).collect(Collectors.toList());
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

    public boolean existById(Long id) {
        return categoryRepository.existsById(id);
    }


    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
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
}
