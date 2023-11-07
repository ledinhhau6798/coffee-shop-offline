package com.cg.model;

<<<<<<< HEAD


import com.cg.bill.DTO.BillDetailResult;
import com.cg.bill.DTO.BillResult;

=======
import com.cg.bill.dto.BillCreateResDTO;
import com.cg.bill.dto.BillDTO;
import lombok.AllArgsConstructor;
>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4
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
