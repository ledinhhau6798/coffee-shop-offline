package com.cg.bill;



import com.cg.bill.DTO.BillDetailResult;
import com.cg.bill.dto.BillResult;

import java.util.List;


public interface IBillService {
    List<BillResult> findAllBillDTO();

    BillDetailResult findBillById(String billIdStr);

    List<BillResult> findBillByCreatedAts(String eventDate);

    BillResult createBill(String tableId);

    List<BillResult> getBillByDate(Integer year, Integer month, Integer day);

    List<BillResult> findAll();


}
