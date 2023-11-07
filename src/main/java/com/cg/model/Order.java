package com.cg.model;



<<<<<<< HEAD
import com.cg.order.DTO.OrderCreResDTO;
import com.cg.order.DTO.OrderResult;
import com.cg.order.DTO.OrderResDTO;
import com.cg.order.DTO.OrderUpResDTO;
import com.cg.orderDetail.DTO.OrderDetailResult;
=======
import com.cg.order.dto.OrderCreResDTO;
import com.cg.order.dto.OrderDTO;
import com.cg.order.dto.OrderResDTO;
import com.cg.order.dto.OrderUpResDTO;
import com.cg.orderDetail.dto.OrderDetailDTO;
>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
@Accessors(chain = true)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staff_id",referencedColumnName = "id",nullable = false)
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "table_order_id",referencedColumnName = "id",nullable = false)
    private TableOrder tableOrder;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    private Boolean paid;

    public OrderResDTO toOrderResDTO() {
        List<OrderDetailResult> orderDetailResults = new ArrayList<>();
        for(int i=0;i<this.getOrderDetails().size();i++){
            OrderDetailResult orderDetailResult = this.getOrderDetails().get(i).toOrderDetailDTO();
            orderDetailResults.add(orderDetailResult);
        }
        return new OrderResDTO()
                .setId(id)
                .setStaff(staff.toStaffDTO())
                .setTableOrder(tableOrder.toTableOrderDTO())
                .setOrderDetails(orderDetailResults)
                .setPaid(paid)
                ;
    }

    public OrderResult toOrderDTO() {
        return new OrderResult()
                .setId(id)
                .setTotalAmount(totalAmount)
                ;
    }

    public OrderCreResDTO toOrderCreResDTO() {
        return new OrderCreResDTO()
                .setTableId(tableOrder.getId())
                ;
    }

    public OrderUpResDTO toOrderUpResDTO() {
        return new OrderUpResDTO()
                .setTableId(tableOrder.getId())
                ;
    }
}
