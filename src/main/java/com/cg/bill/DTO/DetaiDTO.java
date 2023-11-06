package com.cg.bill.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Accessors(chain = true)
public class DetaiDTO {
    private BigDecimal amount;
    private String note;
    private BigDecimal price;
    private Long quantity;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
}
