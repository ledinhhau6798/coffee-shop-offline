package com.cg.bill.dto;

<<<<<<<< HEAD:src/main/java/com/cg/bill/dto/CretaionBillParam.java
import com.cg.tableOrder.DTO.TableOrderDTO;
========
import com.cg.tableOrder.dto.TableOrderDTO;
import lombok.AllArgsConstructor;
>>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4:src/main/java/com/cg/bill/dto/BillCreateResDTO.java
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
