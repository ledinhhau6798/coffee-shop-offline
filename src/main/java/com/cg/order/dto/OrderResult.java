
package com.cg.order.dto;
<<<<<<< HEAD:src/main/java/com/cg/order/dto/OrderDTO.java
import com.cg.orderDetail.dto.OrderDetailDTO;
import com.cg.staff.dto.StaffResult;
import com.cg.tableOrder.dto.TableOrderResult;
=======

import com.cg.orderDetail.dto.OrderDetailResult;
import com.cg.staff.dto.StaffDTO;
import com.cg.tableOrder.dto.TableOrderDTO;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/order/dto/OrderResult.java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class OrderResult {
    private Long id;
    private StaffResult staff;
    private TableOrderResult tableOrder;
    private BigDecimal totalAmount;
<<<<<<< HEAD:src/main/java/com/cg/order/dto/OrderDTO.java
    private OrderDetailDTO orderDetailDTO;
=======

    private OrderDetailResult orderDetailResult;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/order/dto/OrderResult.java
    private Boolean paid;

}
