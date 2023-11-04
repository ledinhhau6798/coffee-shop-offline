package com.cg.bill;

import com.cg.model.Bill;
import com.cg.bill.dto.BillCreateResDTO;
import com.cg.bill.dto.BillDTO;
import com.cg.bill.dto.BillDetailDTO;
import com.cg.service.IGeneralService;

import java.util.Date;
import java.util.List;

public interface IBillService extends IGeneralService<Bill,Long> {
    List<BillDTO> findAllBillDTO();

    List<BillDetailDTO> findBillById(Long billId);

    List<BillDTO> findBillByCreatedAts(Date BillDate);

    BillCreateResDTO createBill(Long tableId);

    List<BillDTO> getBillByDate(Integer year, Integer month, Integer day);
}
