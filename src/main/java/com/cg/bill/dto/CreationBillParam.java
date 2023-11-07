package com.cg.bill.dto;

<<<<<<< HEAD
import com.cg.tableOrder.dto.TableOrderResult;
import lombok.AllArgsConstructor;
=======

import com.cg.tableOrder.dto.TableOrderDTO;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class CreationBillParam {
<<<<<<< HEAD

=======
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    private Long id;
    private TableOrderResult table;
    private BigDecimal totalAmount;
    private Long orderId;
    private Boolean paid;
}
