package com.cg.product.dto;

import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.model.ProductAvatar;
<<<<<<< HEAD:src/main/java/com/cg/product/DTO/ProductDTO.java
import com.cg.category.DTO.CategoryResult;
import com.cg.productAvatar.DTO.ProductAvatarResDTO;
=======
import com.cg.category.dto.CategoryDTO;
import com.cg.productAvatar.dto.ProductAvatarResDTO;
>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4:src/main/java/com/cg/product/dto/ProductDTO.java
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
public class ProductDTO {
    private String id;
    private String title;
    private BigDecimal price;

    private String unit;
    private CategoryResult category;
    private ProductAvatarResDTO avatar;

    public ProductDTO(Long id, String title, BigDecimal price,String unit, Category category, ProductAvatar avatar){
        this.id= String.valueOf(id);
        this.title=title;
        this.price=price;
        this.unit = unit;
        this.category=category.toCategoryDTO();
        this.avatar = avatar.toProductAvatarResDTO();
    }


    public ProductDTO toDTO(Product product) {
        return new ProductDTO()
                .setId(String.valueOf(product.getId()))
                .setTitle(product.getTitle())
                .setPrice(product.getPrice())
                .setUnit(product.getUnit())
                .setCategory(product.toDTO().getCategory())
                .setAvatar(product.toDTO().getAvatar());
    }
}
