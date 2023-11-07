package com.cg.orderDetail.dto;

<<<<<<<< HEAD:src/main/java/com/cg/orderDetail/dto/OrderDetailResult.java
========
import com.cg.product.dto.ProductDTO;
>>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4:src/main/java/com/cg/orderDetail/dto/OrderDetailDTO.java
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class OrderDetailResult {
    private Long orderDetailId;
    private String product;
    private String quantity;
    private BigDecimal price;
    private BigDecimal amount;
    private String note;
}
