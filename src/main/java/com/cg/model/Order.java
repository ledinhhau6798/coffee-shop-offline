package com.cg.model;

import com.cg.order.dto.*;

<<<<<<< HEAD

import com.cg.order.dto.OrderCreResDTO;
import com.cg.order.dto.OrderDTO;
import com.cg.order.dto.OrderResDTO;
import com.cg.order.dto.OrderUpResDTO;
import com.cg.orderDetail.dto.OrderDetailDTO;
import com.cg.staff.StaffMapper;
import lombok.*;
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true)
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


<<<<<<< HEAD
=======

    public OrderResult toOrderDTO() {
        return new OrderResult()
                .setId(id)
                .setTotalAmount(totalAmount)
                ;
    }
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272


}
