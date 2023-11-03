package com.cg.model;

import com.cg.bill.DTO.BillCreateResDTO;
import com.cg.bill.DTO.BillDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
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

    public BillCreateResDTO toBillResDTO() {
        return new BillCreateResDTO()
                .setId(order.getId())
                .setTable(order.getTableOrder().toTableOrderDTO())
                .setTotalAmount(order.getTotalAmount())
                .setPaid(getOrder().getPaid())
                .setOrderId(getOrder().getId())
                ;
    }

    public BillDTO toBillDTO() {
        return new BillDTO()
                .setId(order.getId())
                .setTableTitle(order.getTableOrder().getTitle())
                .setTotal(order.getTotalAmount())
                .setCreatedAt(order.getCreatedAt())
                .setStaffName(order.getStaff().getTitle())
                .setOrderId(order.getId())
                ;
    }


}
