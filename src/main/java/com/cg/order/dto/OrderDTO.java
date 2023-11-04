package com.cg.order.dto;
import com.cg.orderDetail.dto.OrderDetailDTO;
import com.cg.staff.dto.StaffDTO;
import com.cg.tableOrder.dto.TableOrderDTO;
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
public class OrderDTO {
    private Long id;
    private StaffDTO staff;
    private TableOrderDTO tableOrder;
    private BigDecimal totalAmount;

    private OrderDetailDTO orderDetailDTO;
    private Boolean paid;

}
