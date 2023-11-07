

package com.cg.order.dto;

import com.cg.orderDetail.dto.OrderDetailResult;
import com.cg.staff.dto.StaffDTO;
import com.cg.tableOrder.dto.TableOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderResDTO {
    private Long id;
    private StaffDTO staff;
    private TableOrderDTO tableOrder;
    private List<OrderDetailResult> orderDetails;
    private Boolean paid;

}
