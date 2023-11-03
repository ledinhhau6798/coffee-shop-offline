package com.cg.orderDetail;

import com.cg.model.OrderDetail;
import com.cg.orderDetail.DTO.OrderDetailByTableResDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IOrderDetailService extends IGeneralService<OrderDetail,Long> {
    List<OrderDetailByTableResDTO> getOrderDetailByTableResDTO(Long orderId);

}
