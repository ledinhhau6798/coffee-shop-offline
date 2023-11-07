package com.cg.bill.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
<<<<<<< HEAD
@NoArgsConstructor
=======

>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
@Getter
@Setter
@Accessors(chain = true)
public class BillResult {
<<<<<<< HEAD
=======

>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    private Long id;
    private String tableTitle;
    private BigDecimal total;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
    private String staffName;
    private Long orderId;

    public BillResult(Long id, String tableTitle, BigDecimal total, Date createdAt, String staffName, Long orderId) {
        this.id = id;
        this.tableTitle = tableTitle;
        this.total = total;
        this.createdAt = createdAt;
        this.staffName = staffName;
        this.orderId = orderId;
    }

<<<<<<< HEAD
    public BillResult(Long id, String tableTitle, BigDecimal total, Date createdAt, String staffName, Long orderId) {
        this.id = id;
        this.tableTitle = tableTitle;
        this.total = total;
        this.createdAt = createdAt;
        this.staffName = staffName;
        this.orderId = orderId;
=======
    public BillResult() {
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    }
}
