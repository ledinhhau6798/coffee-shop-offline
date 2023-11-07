package com.cg.order;

import com.cg.exception.DataInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.*;
import com.cg.order.dto.CreationOrderParam;
import com.cg.order.dto.OrderUpChangeToTableReqDTO;
import com.cg.order.dto.OrderUpChangeToTableResDTO;
import com.cg.order.dto.OrderUpReqDTO;

import com.cg.model.enums.ETableStatus;
import com.cg.orderDetail.IOrderDetailService;
import com.cg.orderDetail.dto.OrderDetailResult;
import com.cg.orderDetail.dto.UpdateOrderDetaiParam;
import com.cg.product.IProductService;
import com.cg.tableOrder.ITableOrderService;
import com.cg.user.IUserService;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderAPI {

    private final IOrderService orderService;
<<<<<<< HEAD
    private final IOrderDetailService orderDetailService;
    private final ValidateUtils validateUtils;
    private final ITableOrderService tableOrderService;
    private final IUserService userService;
    private final IProductService productService;
=======


    private final IOrderDetailService orderDetailService;


    private final ValidateUtils validateUtils;


    private final ITableOrderService tableOrderService;


    private final IUserService userService;


    private final IProductService productService;


>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    private final AppUtils appUtils;


    @GetMapping("/table/{tableId}")
<<<<<<< HEAD
    public ResponseEntity<?> getOrderByTableId(@PathVariable("tableId") String tableIdStr) {
        if (!validateUtils.isNumberValid(tableIdStr)) {
            throw new DataInputException("Mã số bàn không hợp lệ vui lòng xem lại");
        }
=======
    public ResponseEntity<?> getOrderByTableId(@PathVariable("tableId") String tableIdStr){
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272


<<<<<<< HEAD
        Order order = orderService.findByTableId(tableId);

        List<OrderDetailByTableResDTO> orderDetails = orderDetailService
                .getOrderDetailByTableResDTO(order.getId());

        if (orderDetails.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @GetMapping("/list-order-details/{tableId}")
    public ResponseEntity<?> getListOrderDetailByTableId(@PathVariable("tableId") String tableIdStr) {
        if (!validateUtils.isNumberValid(tableIdStr)) {
            throw new DataInputException("Mã bàn không hợp lệ");
        }
        Long tableId = Long.valueOf(tableIdStr);

        Order order = orderService.findByTableId(tableId);

        List<OrderDetailByTableResDTO> orderDetails = orderDetailService
                .getOrderDetailByTableResDTO(order.getId());
=======
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

>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272


    }

<<<<<<< HEAD
    @PostMapping("/create")
    public ResponseEntity<?> creOrder(@RequestBody OrderCreReqDTO orderCreReqDTO) {
        String username = appUtils.getPrincipalUsername();
        User user = userService.findByUsername(username);
        TableOrder tableOrder = tableOrderService.findById(orderCreReqDTO.getTableId());
        List<Order> orders = orderService.findByTableOrderAndPaid(tableOrder, false);
        if (orders.size() > 0) {
            throw new DataInputException("Bàn này đang có hoá đơn, vui lòng kiểm tra lại thông tin");
        }

        if (tableOrder.getStatus() == ETableStatus.EMPTY) {
            OrderDetailCreResDTO orderDetailCreResDTO = orderService
                    .creOrder(orderCreReqDTO, tableOrder, user);

            return new ResponseEntity<>(orderDetailCreResDTO, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> upOrder(@RequestBody OrderUpReqDTO orderUpReqDTO) {
        String username = appUtils.getPrincipalUsername();
        User user = userService.findByUsername(username);

        TableOrder tableOrder = tableOrderService.findById(orderUpReqDTO.getTableId());

        Product product = productService.findById(orderUpReqDTO.getProductId());
=======
    @PatchMapping()
    public ResponseEntity<?> upOrder(@RequestBody OrderUpReqDTO orderUpReqDTO){


>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

            UpdateOrderDetaiParam updateOrderDetaiParam = orderService.upOrderDetail(orderUpReqDTO);
            return new ResponseEntity<>(updateOrderDetaiParam,HttpStatus.OK);

<<<<<<< HEAD
        if (orders.size() == 0) {
            throw new DataInputException("Bàn này không có hoá đơn, vui lòng kiểm tra lại thông tin");
        }

        if (orders.size() > 1) {
            throw new DataInputException("Lỗi hệ thống, vui lòng liên hệ ADMIN để kiểm tra lại dữ liệu");
        }

        Order order = orders.get(0);

        if (tableOrder.getStatus() == ETableStatus.BUSY) {
            OrderDetailUpResDTO orderDetailUpResDTO = orderService
                    .upOrderDetail(orderUpReqDTO, order, product, user);
            return new ResponseEntity<>(orderDetailUpResDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
=======
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    }

    @DeleteMapping("/{orderDetailId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderDetailId) {
        OrderDetail orderDetail = orderDetailService.findById(orderDetailId)
                .orElseThrow(() -> new DataInputException("Vui lòng kiểm tra lại thông tin"));

        Long orderId = orderDetail.getOrder().getId();
        Long tableId = orderDetail.getOrder().getTableOrder().getId();

        orderDetailService.delete(orderDetail);
<<<<<<< HEAD
        List<OrderDetailByTableResDTO> orderDetails = orderDetailService
                .getOrderDetailByTableResDTO(orderId);
        if (orderDetails.isEmpty()) {
            TableOrder tableOrder = tableOrderService.findById(tableId);
            tableOrder.setStatus(ETableStatus.EMPTY);
            tableOrderService.save(tableOrder);
            return new ResponseEntity<>(tableOrder, HttpStatus.OK);
=======
        List<OrderDetailResult> orderDetails = orderDetailService.getOrderDetailByTableResDTO(String.valueOf(orderId));
        if(orderDetails.isEmpty()){
            Optional<TableOrder> tableOrderOptional = tableOrderService.findById(tableId);
           TableOrder tableOrder = tableOrderOptional.get();
           tableOrder.setStatus(ETableStatus.EMPTY);
           tableOrderService.save(tableOrder);
           return new ResponseEntity<>(tableOrder,HttpStatus.OK);
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
        }
        return new ResponseEntity<>(orderDetail.getOrder().getTableOrder(), HttpStatus.OK);
    }

    @PatchMapping("/update/change-to-table")
    public ResponseEntity<?> changeToTable(@RequestBody OrderUpChangeToTableReqDTO orderUpChangeToTableReqDTO) {
        String username = appUtils.getPrincipalUsername();
        User user = userService.findByUsername(username);

        TableOrder tableOrderBusy = tableOrderService.findById(orderUpChangeToTableReqDTO
                .getTableIdBusy());
        TableOrder tableOrderEmpty = tableOrderService.findById(orderUpChangeToTableReqDTO
                .getTableIdEmpty());

        if (tableOrderEmpty.getId().equals(tableOrderBusy.getId())) {
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


        OrderUpChangeToTableResDTO orderUpChangeToTableResDTO = orderService
                .changeToTable(orderUpChangeToTableReqDTO, user);

        return new ResponseEntity<>(orderUpChangeToTableResDTO, HttpStatus.OK);

    }
}
