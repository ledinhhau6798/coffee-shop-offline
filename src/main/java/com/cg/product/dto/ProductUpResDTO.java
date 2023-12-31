package com.cg.product.dto;

import com.cg.productAvatar.dto.ProductAvatarResult;
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
public class ProductUpResDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private String unit;
    private String categoryTitle;
    private ProductAvatarResult avatar;
}
