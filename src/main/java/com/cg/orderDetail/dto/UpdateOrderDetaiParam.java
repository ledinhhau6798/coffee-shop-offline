package com.cg.orderDetail.dto;

import com.cg.tableOrder.dto.TableOrderResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
<<<<<<< HEAD:src/main/java/com/cg/orderDetail/dto/OrderDetailUpResDTO.java
public class OrderDetailUpResDTO {
    private TableOrderResult table;
=======
public class UpdateOrderDetaiParam {
    private TableOrderResDTO table;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/orderDetail/dto/UpdateOrderDetaiParam.java
    private BigDecimal totalAmount;
    private List<OrderDetailProductUpResDTO> products;
}
