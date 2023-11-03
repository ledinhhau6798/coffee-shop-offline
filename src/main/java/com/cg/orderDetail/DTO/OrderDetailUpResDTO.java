package com.cg.orderDetail.DTO;

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
public class OrderDetailUpResDTO {
    private TableOrderResDTO table;
    private BigDecimal totalAmount;
    private List<OrderDetailProductUpResDTO> products;
}
