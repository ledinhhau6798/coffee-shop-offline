package com.cg.model;



import com.cg.category.dto.CategoryResult;
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

    public CategoryResult toDTO(Long id,String title){
        return new CategoryResult()
                .setId(id)
                .setTitle(title);
    }

<<<<<<< HEAD
    public CategoryDTO toCategoryDTO() {
        return new CategoryDTO()
=======



    public CategoryResult toCategoryDTO() {
        return new CategoryResult()
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
                .setId(id)
                .setTitle(title)
                ;
    }
}
