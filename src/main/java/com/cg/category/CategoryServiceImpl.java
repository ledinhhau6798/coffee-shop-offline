package com.cg.category;

import com.cg.category.DTO.*;
import com.cg.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    CategoryMapper categoryMapper;
    CategoryCreReqMapper categoryCreReqMapper;
    CategoryCreResMapper categoryCreResMapper;
    CategoryUpReqMapper categoryUpReqMapper;
    CategoryUpResMapper categoryUpResMapper;

    private CategoryRepository categoryRepository;


    @Override
    public CategoryCreResDTO createCategory(CategoryCreReqDTO categoryCreReqDTO) {

        Category category = categoryCreReqMapper.toEntity(categoryCreReqDTO);
        categoryRepository.save(category);

        return categoryCreResMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> findAllCategoryDTO() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> categoryMapper.toDTO(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryUpResDTO updateCategory(Long categoryId, CategoryUpReqDTO categoryUpReqDTO) {
        Category category = categoryUpReqDTO.toCategoryUpreqDTO(categoryId);
        categoryRepository.save(categoryUpReqMapper.toEntity(categoryUpReqDTO));

        return category.toCategoryUpResDTO();

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

//    public Category<Object> findById(Long categoryId) {
//        return categoryRepository.findById(categoryId).orElseThrow()
//    }
}
