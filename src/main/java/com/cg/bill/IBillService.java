package com.cg.bill;


<<<<<<< HEAD
import com.cg.model.Bill;
import com.cg.bill.dto.CreationBillParam;
import com.cg.bill.dto.BillResult;
import com.cg.bill.dto.BillDetailResult;
import com.cg.service.IGeneralService;
=======
import com.cg.bill.dto.BillDetailResult;
import com.cg.bill.dto.BillResult;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

import java.util.List;

<<<<<<< HEAD
public interface IBillService extends IGeneralService<Bill,Long> {
    List<BillResult> findAllBillDTO();

    List<BillDetailResult> findBillById(Long billId);

    List<BillResult> findBillByCreatedAts(Date BillDate);

    CreationBillParam createBill(Long tableId);

=======
public interface IBillService  {

    List<BillResult> findAll();




    BillDetailResult findBillById(String billIdStr);

    List<BillResult> findBillByCreatedAts(String eventDate);


    BillResult createBill(String tableIdStr);

>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    List<BillResult> getBillByDate(Integer year, Integer month, Integer day);


}
