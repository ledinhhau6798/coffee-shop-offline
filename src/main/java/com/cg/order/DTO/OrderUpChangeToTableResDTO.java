package com.cg.order.DTO;

import com.cg.orderDetail.DTO.OrderDetailProductUpResDTO;
import com.cg.tableOrder.DTO.TableOrderResDTO;
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
public class OrderUpChangeToTableResDTO {
    private TableOrderResDTO tableOrder;
    private BigDecimal totalAmount;
    private List<OrderDetailProductUpResDTO> products;

}
