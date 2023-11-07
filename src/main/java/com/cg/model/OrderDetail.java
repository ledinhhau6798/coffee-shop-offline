package com.cg.model;

<<<<<<< HEAD
import com.cg.bill.DTO.DetaiDTO;
import com.cg.category.DTO.CreationCategoryParam;
import com.cg.order.DTO.CreationOrderParam;
import com.cg.orderDetail.DTO.OrderDetailResult;
=======
import com.cg.orderDetail.dto.OrderDetailDTO;
>>>>>>> c48b11bf393032cd0a7c6729fb0ae25916e28ef4
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
@Table(name = "order_detail")
@Accessors(chain = true)
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id",nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id",nullable = false)
    private Product product;

    @Column
    private Long quantity;

    @Column
    private BigDecimal price;

    @Column
    private BigDecimal amount;

    @Column
    private String note;


    public OrderDetailResult toOrderDetailDTO() {
        return new OrderDetailResult()
                .setOrderDetailId(id)
                .setProduct(product.getTitle())
                .setQuantity(String.valueOf(quantity))
                .setPrice(price)
                .setAmount(amount)
                .setNote(note)
                ;
    }
    public DetaiDTO toDetailDTO() {
        return new DetaiDTO()
                .setAmount(amount)
                .setNote(note)
                .setPrice(price)
                .setQuantity(quantity)
                .setTitle(product.getTitle())
                .setCreatedAt(getCreatedAt())
                ;
    }


    public OrderDetailResult toDTO() {
        return new OrderDetailResult()
                .setOrderDetailId(id)
                .setProduct(product.getTitle())
                .setQuantity(String.valueOf(quantity))
                .setPrice(price)
                .setAmount(amount)
                .setNote(note);
    }
}
