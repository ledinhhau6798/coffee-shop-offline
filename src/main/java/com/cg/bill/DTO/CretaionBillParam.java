package com.cg.bill.DTO;

import com.cg.tableOrder.DTO.TableOrderDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class CretaionBillParam {
    private Long id;
    private TableOrderDTO table;
    private BigDecimal totalAmount;
    private Long orderId;
    private Boolean paid;
}
