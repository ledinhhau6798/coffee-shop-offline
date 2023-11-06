package com.cg.orderDetail;

import com.cg.category.DTO.CreationCategoryParam;
import com.cg.model.Order;
import com.cg.model.OrderDetail;
import com.cg.orderDetail.DTO.OrderDetailByTableResDTO;
import com.cg.orderDetail.DTO.OrderDetailProductUpResDTO;
import com.cg.orderDetail.DTO.OrderDetailResult;
import com.cg.orderDetail.DTO.UpdateOrderDetaiParam;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDetailMapper {


    public List<OrderDetailResult> toDTOList(List<OrderDetailByTableResDTO> orderDetailByTableResDTO) {
        return orderDetailByTableResDTO.stream().map(this::toDTO).collect(Collectors.toList());
    }



    public OrderDetailResult toDTO(OrderDetailByTableResDTO entity) {
        return entity.toDTO();
    }
    public OrderDetailResult toDTO(OrderDetail entity) {
        return entity.toDTO();
    }


    public UpdateOrderDetaiParam toDTO(Order order, List<OrderDetailProductUpResDTO> newOrderDetails) {
        return new UpdateOrderDetaiParam()
        .setTable(order.getTableOrder().toTableOrderResDTO())
        .setProducts(newOrderDetails)
        .setTotalAmount(order.getTotalAmount());

    }
}
