package com.cg.bill;


import com.cg.bill.dto.BillDetailResult;
import com.cg.bill.dto.BillResult;
import com.cg.model.Bill;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor


public class BillMapper {
    public BillResult toDTO(Bill entity){
        return new BillResult()
                .setId(entity.getId())
                .setTableTitle(entity.getOrder().getTableOrder().getTitle())
                .setTotal(entity.getOrder().getTotalAmount())
                .setCreatedAt(entity.getOrder().getCreatedAt())
                .setStaffName(entity.getOrder().getStaff().getTitle())
                .setOrderId(entity.getOrder().getId())
                ;
    }


    public List<BillResult> toDTOList(List<Bill> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public BillDetailResult toDTOBillDetai(Bill entity) {
        return null;
    }
}
