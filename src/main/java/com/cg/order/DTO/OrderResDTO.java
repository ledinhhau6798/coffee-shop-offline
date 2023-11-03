package com.cg.order.DTO;
import com.cg.orderDetail.DTO.OrderDetailDTO;
import com.cg.staff.DTO.StaffDTO;
import com.cg.tableOrder.DTO.TableOrderDTO;
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
    private List<OrderDetailDTO> orderDetails;
    private Boolean paid;

}
