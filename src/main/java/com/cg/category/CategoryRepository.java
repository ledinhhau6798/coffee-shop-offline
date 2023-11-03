package com.cg.category;

import com.cg.model.Category;
import com.cg.category.DTO.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

<<<<<<< HEAD
=======
//    @Query("SELECT NEW com.cg.model.dto.category.CategoryDTO (" +
//            "ca.id, " +
//            "ca.title) " +
//            "FROM Category AS ca " +
//            "WHERE ca.deleted = false ")
//    List<CategoryDTO> findAllCategoryDTO();

>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a

    Optional<Category> findByIdAndDeletedFalse(Long id);
}
