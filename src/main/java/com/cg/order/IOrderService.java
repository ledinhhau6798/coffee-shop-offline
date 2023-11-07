package com.cg.order;


<<<<<<< HEAD
import com.cg.order.DTO.CreationOrderParam;
import com.cg.order.DTO.OrderUpChangeToTableReqDTO;
import com.cg.order.DTO.OrderUpChangeToTableResDTO;
import com.cg.order.DTO.OrderUpReqDTO;
import com.cg.model.*;
import com.cg.orderDetail.DTO.OrderDetailResult;
import com.cg.orderDetail.DTO.UpdateOrderDetaiParam;
=======
import com.cg.order.dto.OrderCreReqDTO;
import com.cg.order.dto.OrderUpChangeToTableReqDTO;
import com.cg.order.dto.OrderUpChangeToTableResDTO;
import com.cg.order.dto.OrderUpReqDTO;
import com.cg.model.*;
import com.cg.orderDetail.dto.OrderDetailCreResDTO;
import com.cg.orderDetail.dto.OrderDetailUpResDTO;
>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4
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
