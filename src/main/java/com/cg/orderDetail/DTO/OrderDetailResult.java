package com.cg.orderDetail.DTO;

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
