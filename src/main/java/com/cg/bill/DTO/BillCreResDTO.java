package com.cg.bill.DTO;

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
public class BillCreResDTO {
    private Long id;
    private TableOrderDTO table;
    private BigDecimal totalAmount;
    private Long orderId;
    private Boolean paid;

}
