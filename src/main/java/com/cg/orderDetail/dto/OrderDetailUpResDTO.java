package com.cg.orderDetail.dto;

import com.cg.tableOrder.dto.TableOrderResDTO;
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
public class UpdateOrderDetaiParam {
    private TableOrderResDTO table;
    private BigDecimal totalAmount;
    private List<OrderDetailProductUpResDTO> products;
}
