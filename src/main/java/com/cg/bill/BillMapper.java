package com.cg.bill;


import com.cg.bill.DTO.BillDetailResult;
import com.cg.bill.DTO.BillResult;

import com.cg.model.Bill;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class BillMapper {

    public BillResult toDTO(Bill entity) {
        return entity.toDTO();
    }

    public BillDetailResult toDTOBillDetai(Bill entity) {
        return entity.toDetaiResultDTO();
    }
    public List<BillResult> toDTOList(List<Bill> entitys) {
        return entitys.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
