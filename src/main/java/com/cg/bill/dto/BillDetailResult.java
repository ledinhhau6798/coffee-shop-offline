package com.cg.bill.DTO;

import com.cg.bill.dto.DetaiResult;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BillDetailResult {

    private Long id;
    private BigDecimal totalAmount;
    private List<DetaiResult> detaiDTOS;



}
