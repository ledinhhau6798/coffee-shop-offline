package com.cg.orderDetail.dto;

<<<<<<< HEAD:src/main/java/com/cg/orderDetail/dto/OrderDetailDTO.java
import com.cg.product.dto.ProductResult;
=======

>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/orderDetail/dto/OrderDetailResult.java
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
<<<<<<< HEAD:src/main/java/com/cg/orderDetail/dto/OrderDetailDTO.java
    private ProductResult product;
=======
    private String product;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/orderDetail/dto/OrderDetailResult.java
    private String quantity;
    private BigDecimal price;
    private BigDecimal amount;
    private String note;
}
