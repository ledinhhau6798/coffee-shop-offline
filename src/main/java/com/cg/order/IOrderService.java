package com.cg.order;


import com.cg.order.DTO.OrderCreReqDTO;
import com.cg.order.DTO.OrderUpChangeToTableReqDTO;
import com.cg.order.DTO.OrderUpChangeToTableResDTO;
import com.cg.order.DTO.OrderUpReqDTO;
import com.cg.model.*;
import com.cg.orderDetail.DTO.OrderDetailCreResDTO;
import com.cg.orderDetail.DTO.OrderDetailUpResDTO;
import com.cg.service.IGeneralService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IOrderService extends IGeneralService<Order,Long> {
    Optional<Order> findByTableId(Long tableId);

    List<Order> findByTableOrderAndPaid(TableOrder tableOrder, Boolean paid);


    OrderDetailCreResDTO creOrder(OrderCreReqDTO orderCreReqDTO, TableOrder tableOrder, User user);

    OrderDetailUpResDTO upOrderDetail(OrderUpReqDTO orderUpReqDTO, Order order, Product product, User user);

    OrderUpChangeToTableResDTO changeToTable(OrderUpChangeToTableReqDTO orderUpChangeToTableReqDTO, User user);

    BigDecimal getOrderTotalAmount(Long orderId);

}
