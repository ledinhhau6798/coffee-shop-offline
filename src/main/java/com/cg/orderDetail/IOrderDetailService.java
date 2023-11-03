package com.cg.orderDetail;

import com.cg.model.OrderDetail;
import com.cg.orderDetail.DTO.OrderDetailByTableResDTO;
import com.cg.service.IGeneralService;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a

public interface IOrderDetailService extends IGeneralService<OrderDetail,Long> {
    List<OrderDetailByTableResDTO> getOrderDetailByTableResDTO(Long orderId);

<<<<<<< HEAD
=======
    Optional<OrderDetail> findByOrderDetailByIdProductAndIdOrder(Long idProduct, Long idOrder, String note);

    OrderDetail findByOrderId(Long orderId);
>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a
}
