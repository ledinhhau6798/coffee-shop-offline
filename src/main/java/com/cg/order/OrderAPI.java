package com.cg.order;

import com.cg.exception.DataInputException;
import com.cg.model.*;
import com.cg.order.DTO.CreationOrderParam;
import com.cg.order.DTO.OrderUpChangeToTableReqDTO;
import com.cg.order.DTO.OrderUpChangeToTableResDTO;
import com.cg.order.DTO.OrderUpReqDTO;
import com.cg.orderDetail.DTO.OrderDetailByTableResDTO;
import com.cg.orderDetail.DTO.OrderDetailResult;
import com.cg.orderDetail.DTO.UpdateOrderDetaiParam;
import com.cg.model.enums.ETableStatus;
import com.cg.orderDetail.IOrderDetailService;
import com.cg.product.IProductService;
import com.cg.tableOrder.ITableOrderService;
import com.cg.user.IUserService;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderAPI {

    private final IOrderService orderService;


    private final IOrderDetailService orderDetailService;


    private final ValidateUtils validateUtils;


    private final ITableOrderService tableOrderService;


    private final IUserService userService;


    private final IProductService productService;


    private final AppUtils appUtils;


    @GetMapping("/table/{tableId}")
    public ResponseEntity<?> getOrderByTableId(@PathVariable("tableId") String tableIdStr){


        List<OrderDetailResult> orderDetails = orderDetailService.getOrderDetailByTableResDTO(tableIdStr);

        if(orderDetails.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderDetails,HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<?> creOrder(@RequestBody CreationOrderParam creationOrderParam){

        OrderDetailResult orderDetailResult = orderService.creOrder(creationOrderParam);

            return new ResponseEntity<>(orderDetailResult, HttpStatus.CREATED);



    }

    @PatchMapping()
    public ResponseEntity<?> upOrder(@RequestBody OrderUpReqDTO orderUpReqDTO){



            UpdateOrderDetaiParam updateOrderDetaiParam = orderService.upOrderDetail(orderUpReqDTO);
            return new ResponseEntity<>(updateOrderDetaiParam,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{orderDetailId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderDetailId) {
        OrderDetail orderDetail = orderDetailService.findById(orderDetailId).orElseThrow(() -> {
            throw new DataInputException("Vui lòng kiểm tra lại thông tin");
        });

        Long orderId = orderDetail.getOrder().getId();
        Long tableId = orderDetail.getOrder().getTableOrder().getId();

        orderDetailService.delete(orderDetail);
        List<OrderDetailResult> orderDetails = orderDetailService.getOrderDetailByTableResDTO(String.valueOf(orderId));
        if(orderDetails.isEmpty()){
            Optional<TableOrder> tableOrderOptional = tableOrderService.findById(tableId);
           TableOrder tableOrder = tableOrderOptional.get();
           tableOrder.setStatus(ETableStatus.EMPTY);
           tableOrderService.save(tableOrder);
           return new ResponseEntity<>(tableOrder,HttpStatus.OK);
        }
        return new ResponseEntity<>(orderDetail.getOrder().getTableOrder(), HttpStatus.OK);
    }

    @PatchMapping("/update/change-to-table")
    public ResponseEntity<?> changeToTable(@RequestBody OrderUpChangeToTableReqDTO orderUpChangeToTableReqDTO) {
        String username = appUtils.getPrincipalUsername();
        Optional<User> userOptional = userService.findByName(username);

        TableOrder tableOrderBusy = tableOrderService.findById(orderUpChangeToTableReqDTO.getTableIdBusy()).orElseThrow(() -> {
            throw new DataInputException("Bàn không tồn tại");
        });
        TableOrder tableOrderEmpty = tableOrderService.findById(orderUpChangeToTableReqDTO.getTableIdEmpty()).orElseThrow(() -> {
            throw new DataInputException("Bàn không tồn tại");
        });

        if(tableOrderEmpty.getId().equals(tableOrderBusy.getId()) ) {
            throw new DataInputException("Bàn chuyển và bàn chuyển là một xin vui lòng kiểm tra lại");
        }

        List<Order> orderEmptys = orderService.findByTableOrderAndPaid(tableOrderEmpty, false);
        List<Order> orderBusys = orderService.findByTableOrderAndPaid(tableOrderBusy, false);

        if (orderBusys.size() == 0) {
            throw new DataInputException("Bàn chuyển này không có hoá đơn, vui lòng kiểm tra lại thông tin");
        }

        if (orderBusys.size() > 1) {
            throw new DataInputException("Lỗi hệ thống, vui lòng liên hệ ADMIN để kiểm tra lại dữ liệu");
        }

        if (orderEmptys.size() != 0) {
            throw new DataInputException("Bàn nhận này đang có hoá đơn, vui lòng kiểm tra lại thông tin");
        }


        OrderUpChangeToTableResDTO orderUpChangeToTableResDTO = orderService.changeToTable(orderUpChangeToTableReqDTO, userOptional.get());

        return new ResponseEntity<>(orderUpChangeToTableResDTO, HttpStatus.OK);

    }
}
