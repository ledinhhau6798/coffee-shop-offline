package com.cg.bill;


import com.cg.bill.dto.BillDetailResult;
import com.cg.bill.dto.BillResult;
import com.cg.bill.dto.CreationBillParam;
import com.cg.exception.DataInputException;
<<<<<<< HEAD

import com.cg.bill.dto.CreationBillParam;
import com.cg.bill.dto.BillResult;
import com.cg.bill.dto.BillDetailResult;
=======
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import com.cg.tableOrder.ITableOrderService;
import com.cg.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillAPI {


    private final IBillService billService;


    private final ValidateUtils validateUtils;


    private final ITableOrderService tableOrderService;


    @GetMapping
    public ResponseEntity<?> showBill() {

<<<<<<< HEAD
        List<BillResult> billResults = billService.findAllBillDTO();
=======
        List<BillResult> billDTOS = billService.findAll();
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

        return new ResponseEntity<>(billResults, HttpStatus.OK);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<?> showBillDetail(@PathVariable("billId") String billIdStr) {



<<<<<<< HEAD
        List<BillDetailResult> billDetailResults = billService.findBillById(billId);
        return new ResponseEntity<>(billDetailResults, HttpStatus.OK);
=======

        return new ResponseEntity<>(billService.findBillById(billIdStr), HttpStatus.OK);
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    }

    @GetMapping("/search/day")
    public ResponseEntity<?> seachBill(@RequestParam("eventDate") String eventDate) {

<<<<<<< HEAD
        List<BillResult> billResults = billService.findBillByCreatedAts(dateBill);
=======

        List<BillResult> billDTOS = billService.findBillByCreatedAts(eventDate);
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

        return new ResponseEntity<>(billResults, HttpStatus.OK);
    }

    @PostMapping("/{tableId}")
    public ResponseEntity<?> createBill(@PathVariable("tableId") String tableIdStr) {

<<<<<<< HEAD
        if (!validateUtils.isNumberValid(tableIdStr)) {
            throw new DataInputException("Mã bàn không hợp lệ");
        }

        Long tableId = Long.parseLong(tableIdStr);

//        tableOrderService.findById(tableId).orElseThrow(() -> {
//            throw new DataInputException("Mã bàn không tồn tại");
//        });
=======


        BillResult billResDTO = billService.createBill(tableIdStr);
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

        Boolean isExisted = tableOrderService.existById(tableId);
        if(!isExisted) {
            throw  new DataInputException("Mã bàn không tồn tại");
        }

        CreationBillParam billResDTO = billService.createBill(tableId);

        return new ResponseEntity<>(billResDTO, HttpStatus.CREATED);

    }


    @GetMapping("date")
    public ResponseEntity<?> getBillByDate(@RequestParam(required = false) Integer day, @RequestParam Integer month, @RequestParam Integer year) {
        return new ResponseEntity<>(billService.getBillByDate(year, month, day), HttpStatus.OK);
    }

}
