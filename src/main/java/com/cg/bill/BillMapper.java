package com.cg.bill;


import com.cg.bill.dto.BillDetailResult;
import com.cg.bill.dto.BillResult;
import com.cg.bill.dto.CreationBillParam;
import com.cg.model.Bill;
import com.cg.tableOrder.TableOrderMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor

public class BillMapper {
    private final TableOrderMapper tableOrderMapper;

    public CreationBillParam toCreationBillParam(Bill entity) {
        return new CreationBillParam()
                .setId(entity.getOrder().getId())
                .setTable(tableOrderMapper.toDTO(entity.getOrder().getTableOrder()))
                .setTotalAmount(entity.getOrder().getTotalAmount())
                .setPaid(entity.getOrder().getPaid())
                .setOrderId(entity.getOrder().getId())
                ;
    }

    public BillResult toBillResult(Bill entity) {
        return new BillResult()
                .setId(entity.getOrder().getId())
                .setTableTitle(entity.getOrder().getTableOrder().getTitle())
                .setTotal(entity.getOrder().getTotalAmount())
                .setCreatedAt(entity.getOrder().getCreatedAt())
                .setStaffName(entity.getOrder().getStaff().getTitle())
                .setOrderId(entity.getOrder().getId())
                ;
    }

    public List<BillResult> toListBillResult(List<Bill> entities) {
        return entities.stream().map(this::toBillResult).collect(Collectors.toList());
    }

    public BillDetailResult toBillDetailResult(Bill entity) {
        return new BillDetailResult().setId(entity.getId());
    }
}
