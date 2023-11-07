package com.cg.product.dto;

import com.cg.category.dto.CategoryResult;
import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.model.ProductAvatar;
<<<<<<< HEAD:src/main/java/com/cg/product/dto/ProductResult.java
import com.cg.category.dto.CategoryDTO;
import com.cg.productAvatar.dto.ProductAvatarResult;
=======

import com.cg.productAvatar.dto.ProductAvatarResDTO;

>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/product/dto/ProductDTO.java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductResult {
    private String id;
    private String title;
    private BigDecimal price;

    private String unit;
<<<<<<< HEAD:src/main/java/com/cg/product/dto/ProductResult.java
    private CategoryDTO category;
    private ProductAvatarResult avatar;
=======
    private CategoryResult category;
    private ProductAvatarResDTO avatar;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/product/dto/ProductDTO.java

    public ProductResult(Long id, String title, BigDecimal price, String unit, Category category, ProductAvatar avatar){
        this.id= String.valueOf(id);
        this.title=title;
        this.price=price;
        this.unit = unit;
        this.category=category.toCategoryDTO();
        this.avatar = avatar.toProductAvatarResDTO();
    }


    public ProductResult toDTO(Product product) {
        return new ProductResult()
                .setId(String.valueOf(product.getId()))
                .setTitle(product.getTitle())
                .setPrice(product.getPrice())
                .setUnit(product.getUnit())
                .setCategory(product.toDTO().getCategory())
                .setAvatar(product.toDTO().getAvatar());
    }
}
