package com.cg.model;

<<<<<<< HEAD

import com.cg.category.DTO.CategoryDTO;
=======
import com.cg.category.DTO.CategoryCreResDTO;
import com.cg.category.DTO.CategoryDTO;
import com.cg.category.DTO.CategoryUpResDTO;
>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="categories")
@Accessors(chain = true)
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;


    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public CategoryDTO toDTO(Long id, String title){
        return new CategoryDTO()
                .setId(id)
                .setTitle(title);
    }




    public CategoryDTO toCategoryDTO() {
        return new CategoryDTO()
                .setId(id)
                .setTitle(title)
                ;
    }
}
