package com.cg.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

import java.util.List;


@Getter
@Setter
@Accessors(chain = true)
public class BillDetailResult {

    private Long id;
    private BigDecimal totalAmount;
    private List<DetaiResult> detaiDTOS;

    public BillDetailResult() {
    }

    public BillDetailResult(Long id, BigDecimal totalAmount, List<DetaiResult> detaiDTOS) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.detaiDTOS = detaiDTOS;
    }
}
