package com.cg.order.DTO;
import com.cg.orderDetail.DTO.OrderDetailResult;
import com.cg.staff.DTO.StaffDTO;
import com.cg.tableOrder.DTO.TableOrderDTO;
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
