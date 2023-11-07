package com.cg.bill;


import com.cg.bill.DTO.BillDetailResult;

import com.cg.bill.dto.BillResult;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillAPI {


    private final IBillService billService;




    @GetMapping
    public ResponseEntity<?> findAll() {

        List<BillResult> billDTOS = billService.findAll();
        return new ResponseEntity<>(billDTOS, HttpStatus.OK);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<?> showBillDetail(@PathVariable("billId") String billIdStr) {

       BillDetailResult  billDetailDTOS = billService.findBillById(billIdStr);
        return new ResponseEntity<>(billDetailDTOS, HttpStatus.OK);
    }

    @GetMapping("/search/day")
    public ResponseEntity<?> seachBill(@RequestParam("eventDate") String eventDate) {


        List<BillResult> billResults = billService.findBillByCreatedAts(eventDate);

        return new ResponseEntity<>(billResults, HttpStatus.OK);
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
