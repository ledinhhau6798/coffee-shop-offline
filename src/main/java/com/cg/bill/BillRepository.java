package com.cg.bill;

import com.cg.model.Bill;
import com.cg.bill.DTO.BillDTO;
import com.cg.bill.DTO.BillDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {



    @Query("select new com.cg.bill.DTO.BillDetailDTO (" +
            "b.id, " +
            "b.totalAmount, " +
            "od.amount, " +
            "od.note, " +
            "od.price, " +
            "od.quantity, " +
            "p.title, " +
            "od.createdAt " +
            ")" +
            "from Bill as b " +
            "join Order as o on b.order.id = o.id "  +
            "join OrderDetail as od on od.order.id = o.id " +
            "join Product as p on od.product.id = p.id " +
            "where b.id = :billId ")
    List<BillDetailDTO> findBillById(@Param("billId") Long billId);

    @Query("SELECT NEW com.cg.bill.DTO.BillDTO (" +
            "b.id, " +
            "b.order.tableOrder.title, " +
            "b.order.totalAmount, " +
            "b.createdAt, " +
            "b.order.staff.title, " +
            "b.order.id" +
            ") " +
            "FROM Bill AS b " +
            "WHERE DATE(b.createdAt) = :eventDate"
    )
    List<BillDTO> findBillByCreatedAts(@Param("eventDate") Date eventDate);

    @Query(value = "SELECT b FROM Bill b WHERE " +
            "DATE_FORMAT(b.createdAt, '%Y-%m-%d') >= DATE_FORMAT(:start, '%Y-%m-%d')" +
            " AND DATE_FORMAT(b.createdAt, '%Y-%m-%d') <= DATE_FORMAT(:end, '%Y-%m-%d')")
    List<BillDTO> getAllBillByDate(LocalDate start, LocalDate end);



}
