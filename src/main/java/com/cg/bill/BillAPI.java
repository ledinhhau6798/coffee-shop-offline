package com.cg.bill;


import com.cg.bill.dto.BillDetailResult;
import com.cg.bill.dto.BillResult;
import com.cg.bill.dto.CreationBillParam;
import com.cg.exception.DataInputException;
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

        List<BillResult> billDTOS = billService.findAll();

        return new ResponseEntity<>(billDTOS, HttpStatus.OK);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<?> showBillDetail(@PathVariable("billId") String billIdStr) {




        return new ResponseEntity<>(billService.findBillById(billIdStr), HttpStatus.OK);
    }

    @GetMapping("/search/day")
    public ResponseEntity<?> seachBill(@RequestParam("eventDate") String eventDate) {


        List<BillResult> billDTOS = billService.findBillByCreatedAts(eventDate);

        return new ResponseEntity<>(billDTOS, HttpStatus.OK);
    }

    @PostMapping("/{tableId}")
    public ResponseEntity<?> createBill(@PathVariable("tableId") String tableIdStr){



        BillResult billResDTO = billService.createBill(tableIdStr);

        return new ResponseEntity<>(billResDTO,HttpStatus.CREATED);

    }


    @GetMapping("date")
    public ResponseEntity<?> getBillByDate(@RequestParam(required = false) Integer day, @RequestParam Integer month, @RequestParam Integer year){
        return new ResponseEntity<>(billService.getBillByDate(year,month,day),HttpStatus.OK);
    }

}
