package com.cg.bill;


import com.cg.bill.dto.BillDetailResult;
import com.cg.bill.dto.BillResult;

import java.util.List;

public interface IBillService  {

    List<BillResult> findAll();




    BillDetailResult findBillById(String billIdStr);

    List<BillResult> findBillByCreatedAts(String eventDate);


    BillResult createBill(String tableIdStr);

    List<BillResult> getBillByDate(Integer year, Integer month, Integer day);


}
