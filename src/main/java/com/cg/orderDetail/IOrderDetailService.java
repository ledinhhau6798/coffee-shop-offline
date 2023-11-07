package com.cg.orderDetail;

import com.cg.model.OrderDetail;
<<<<<<< HEAD
import com.cg.orderDetail.DTO.OrderDetailByTableResDTO;
import com.cg.orderDetail.DTO.OrderDetailResult;
=======
import com.cg.orderDetail.dto.OrderDetailByTableResDTO;
>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4
import com.cg.service.IGeneralService;

import java.util.List;
import java.util.Optional;


public interface IOrderDetailService extends IGeneralService<OrderDetail,Long> {
    List<OrderDetailResult> getOrderDetailByTableResDTO(String tableIdStr);

    Optional<OrderDetail> findByOrderDetailByIdProductAndIdOrder(Long idProduct, Long idOrder, String note);

    OrderDetail findByOrderId(Long orderId);
}
