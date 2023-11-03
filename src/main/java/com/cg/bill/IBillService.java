package com.cg.bill;

import com.cg.model.Bill;
import com.cg.bill.DTO.BillCreResDTO;
import com.cg.bill.DTO.BillDTO;
import com.cg.bill.DTO.BillDetailDTO;
import com.cg.service.IGeneralService;

import java.util.Date;
import java.util.List;

public interface IBillService extends IGeneralService<Bill,Long> {
    List<BillDTO> findAllBillDTO();

    List<BillDetailDTO> findBillById(Long billId);

    List<BillDTO> findBillByCreatedAts(Date BillDate);

    BillCreResDTO createBill(Long tableId);

    List<BillDTO> getBillByDate(Integer year, Integer month, Integer day);


}
