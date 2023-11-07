<<<<<<<< HEAD:src/main/java/com/cg/order/dto/OrderResult.java
package com.cg.order.DTO;
import com.cg.orderDetail.DTO.OrderDetailResult;
import com.cg.staff.DTO.StaffDTO;
import com.cg.tableOrder.DTO.TableOrderDTO;
========
package com.cg.order.dto;
import com.cg.orderDetail.dto.OrderDetailDTO;
import com.cg.staff.dto.StaffDTO;
import com.cg.tableOrder.dto.TableOrderDTO;
>>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4:src/main/java/com/cg/order/dto/OrderDTO.java
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
    private StaffDTO staff;
    private TableOrderDTO tableOrder;
    private BigDecimal totalAmount;

    private OrderDetailResult orderDetailResult;
    private Boolean paid;

}
