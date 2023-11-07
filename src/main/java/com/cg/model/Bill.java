package com.cg.model;

<<<<<<< HEAD
import com.cg.bill.dto.CreationBillParam;
import com.cg.bill.dto.BillResult;
=======

import com.cg.bill.dto.BillDetailResult;
import com.cg.bill.dto.BillResult;


>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "bills")
@Accessors(chain = true)
public class Bill extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @OneToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id",nullable = false)
    private Order order;

<<<<<<< HEAD
=======


    public BillResult toBillDTO() {
        return new BillResult()
                .setId(order.getId())
                .setTableTitle(order.getTableOrder().getTitle())
                .setTotal(order.getTotalAmount())
                .setCreatedAt(order.getCreatedAt())
                .setStaffName(order.getStaff().getTitle())
                .setOrderId(order.getId())
                ;
    }

>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

    public BillResult toDTO() {
        return new BillResult()
                .setId(order.getId())
                .setTableTitle(order.getTableOrder().getTitle())
                .setTotal(order.getTotalAmount())
                .setCreatedAt(order.getCreatedAt())
                .setStaffName(order.getStaff().getTitle())
                .setOrderId(order.getId())
                ;
    }


    public BillDetailResult toDetaiResultDTO() {
        return new BillDetailResult()
                .setId(id)
                .setTotalAmount(totalAmount)
                .setDetaiDTOS(order.getOrderDetails().stream().map(orderDetail -> orderDetail.toDetailDTO()).collect(Collectors.toList()));

    }
}
