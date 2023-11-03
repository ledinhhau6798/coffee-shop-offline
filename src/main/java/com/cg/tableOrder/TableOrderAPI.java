package com.cg.tableOrder;

import com.cg.exception.DataInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.TableOrder;
import com.cg.tableOrder.DTO.TableOrderCreateReqDTO;
<<<<<<< HEAD
import com.cg.tableOrder.DTO.TableOrderDTO;
=======
import com.cg.tableOrder.DTO.TableOrderCreateResDTO;
import com.cg.tableOrder.DTO.TableOrderDTO;
import com.cg.tableOrder.ITableOrderService;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidateUtils;
>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tableOrders")
public class TableOrderAPI {
    @Autowired
    private ITableOrderService tableOrderService;


    @GetMapping
    public ResponseEntity<?> getAllTableOrder() {
        List<TableOrderDTO> tableOrderDTO = tableOrderService.findAllTableOrderDTO();
        if(tableOrderDTO.isEmpty()) {
            throw new ResourceNotFoundException("Không có bàn nào vui lòng kiểm tra lại hệ thống");
        }
        return new ResponseEntity<>(tableOrderDTO,HttpStatus.OK);
    }

    @GetMapping("/{tableId}")
    public ResponseEntity<?> getTableOrderById(@PathVariable Long tableId){
        Optional<TableOrder> tableOrderOptional = tableOrderService.findById(tableId);

        if(!tableOrderOptional.isPresent()){
            throw new DataInputException("Bàn này không tồn tại xin vui lòng kiểm tra lại");
        }

        return new ResponseEntity<>(tableOrderOptional,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTableOrder(@RequestBody TableOrderCreateReqDTO tableOrderCreateReqDTO){
        return new ResponseEntity<>(tableOrderService.createTableOrder(tableOrderCreateReqDTO),HttpStatus.CREATED);
    }

    @GetMapping("/tables-without-tableSend/{tableId}")
    public ResponseEntity<?> getAllTablesWithoutSender(@PathVariable Long tableId) {

        List<TableOrderDTO> tableSelect = tableOrderService.findAllTablesWithoutSenderId(tableId);

        return new ResponseEntity<>(tableSelect, HttpStatus.OK);
    }

}
