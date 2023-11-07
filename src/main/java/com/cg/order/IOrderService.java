package com.cg.order;



import com.cg.order.dto.CreationOrderParam;
import com.cg.order.dto.OrderUpChangeToTableReqDTO;
import com.cg.order.dto.OrderUpChangeToTableResDTO;
import com.cg.order.dto.OrderUpReqDTO;
import com.cg.model.*;

import com.cg.orderDetail.dto.OrderDetailResult;
import com.cg.orderDetail.dto.UpdateOrderDetaiParam;
import com.cg.service.IGeneralService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IOrderService extends IGeneralService<Order,Long> {
    Optional<Order> findByTableId(Long tableId);

    List<Order> findByTableOrderAndPaid(TableOrder tableOrder, Boolean paid);


    OrderDetailResult creOrder(CreationOrderParam creationOrderParam);

    UpdateOrderDetaiParam upOrderDetail(OrderUpReqDTO orderUpReqDTO);

    OrderUpChangeToTableResDTO changeToTable(OrderUpChangeToTableReqDTO orderUpChangeToTableReqDTO, User user);

    BigDecimal getOrderTotalAmount(Long orderId);

}
