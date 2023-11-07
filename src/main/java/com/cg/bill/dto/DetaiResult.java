package com.cg.bill.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

<<<<<<<< HEAD:src/main/java/com/cg/bill/dto/BillDetailResult.java
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BillDetailResult {

    private Long id;
    private BigDecimal totalAmount;
========
@Getter
@Setter
@Accessors(chain = true)
public class DetaiResult {
>>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/bill/dto/DetaiResult.java
    private BigDecimal amount;
    private String note;
    private BigDecimal price;
    private Long quantity;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;

    public DetaiResult(BigDecimal amount, String note, BigDecimal price, Long quantity, String title, Date createdAt) {
        this.amount = amount;
        this.note = note;
        this.price = price;
        this.quantity = quantity;
        this.title = title;
        this.createdAt = createdAt;
    }

<<<<<<<< HEAD:src/main/java/com/cg/bill/dto/BillDetailResult.java
    public BillDetailResult(Long id, BigDecimal totalAmount, BigDecimal amount, String note, BigDecimal price, Long quantity, String title, Date createdAt) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.amount = amount;
        this.note = note;
        this.price = price;
        this.quantity = quantity;
        this.title = title;
        this.createdAt = createdAt;
========
    public DetaiResult() {
>>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272:src/main/java/com/cg/bill/dto/DetaiResult.java
    }
}
