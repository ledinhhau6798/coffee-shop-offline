package com.cg.bill.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class DetaiResult {
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

    public DetaiResult() {
    }
}
