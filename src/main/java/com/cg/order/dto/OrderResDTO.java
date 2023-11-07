<<<<<<< HEAD:src/main/java/com/cg/order/DTO/OrderResDTO.java
package com.cg.order.DTO;
import com.cg.orderDetail.DTO.OrderDetailResult;
import com.cg.staff.DTO.StaffDTO;
import com.cg.tableOrder.DTO.TableOrderDTO;
=======
package com.cg.order.dto;
import com.cg.orderDetail.dto.OrderDetailDTO;
import com.cg.staff.dto.StaffDTO;
import com.cg.tableOrder.dto.TableOrderDTO;
>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4:src/main/java/com/cg/order/dto/OrderResDTO.java
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
