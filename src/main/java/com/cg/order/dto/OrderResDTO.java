

package com.cg.order.dto;
<<<<<<< HEAD
import com.cg.orderDetail.dto.OrderDetailDTO;
import com.cg.staff.dto.StaffResult;
import com.cg.tableOrder.dto.TableOrderResult;
=======

import com.cg.orderDetail.dto.OrderDetailResult;
import com.cg.staff.dto.StaffDTO;
import com.cg.tableOrder.dto.TableOrderDTO;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
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
<<<<<<< HEAD
    private StaffResult staff;
    private TableOrderResult tableOrder;
    private List<OrderDetailDTO> orderDetails;
=======
    private StaffDTO staff;
    private TableOrderDTO tableOrder;
    private List<OrderDetailResult> orderDetails;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    private Boolean paid;

}
