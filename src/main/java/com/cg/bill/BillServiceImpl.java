package com.cg.bill;

import com.cg.bill.DTO.BillCreateResDTO;
import com.cg.bill.DTO.BillDTO;
import com.cg.bill.DTO.BillDetailDTO;
import com.cg.exception.DataInputException;
import com.cg.model.Bill;
import com.cg.model.Order;
import com.cg.model.TableOrder;
import com.cg.bill.dto.BillCreateResDTO;
import com.cg.bill.dto.BillDTO;
import com.cg.bill.dto.BillDetailDTO;
import com.cg.order.OrderRepository;
import com.cg.tableOrder.TableOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BillServiceImpl implements IBillService {

    private final BillDetailMapper billDetailMapper;
    private final BillMapper billMapper;
    private final BillCreateResMapper billCreateResMapper;


    private final BillRepository billRepository;

    private final TableOrderRepository tableOrderRepository;

    private final OrderRepository orderRepository;

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public void delete(Bill bill) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<BillDTO> findAllBillDTO() {
        return billRepository.findAll().stream().map(Bill::toBillDTO).collect(Collectors.toList());
    }

    @Override
    public List<BillDetailDTO> findBillById(Long billId) {
        return billRepository.findAllById(billId)
                .stream()
                .map(bill -> billDetailMapper.toDTO(bill))
                .collect(Collectors.toList());
    }

    @Override
    public List<BillDTO> findBillByCreatedAts(Date billDate) {
        return billRepository.findAllByCreatedAt(billDate)
                .stream()
                .map(bill -> billMapper.toDTO(bill))
                .collect(Collectors.toList());
    }

    @Override
    public BillCreateResDTO createBill(Long tableId) {
        Order order = orderRepository.findByTableId(tableId).get();
        if (order.getPaid() == true) {
            throw new DataInputException("Bàn này đã thanh toán");
        }
        order.setPaid(true);

        TableOrder tableOrder = tableOrderRepository.findById(tableId)
                .orElseThrow(() -> new DataInputException("Bàn không đặt không thể thanh toán"));
        tableOrderRepository.save(tableOrder);


//        if (tableOrder.getStatus() == ETableStatus.EMPTY) {
//            throw new DataInputException("Bàn không đặt không thể thanh toán");
//        }
//        tableOrder.setStatus(ETableStatus.EMPTY);
//
//        tableOrderRepository.save(tableOrder);

        Bill bill = new Bill();
        bill.setTotalAmount(order.getTotalAmount());
        bill.setOrder(order);
        bill = billRepository.save(bill);


        BillCreateResDTO billResDTO = bill.toBillResDTO();
        return billResDTO;
    }

    @Override
    public List<BillDTO> getBillByDate(Integer year, Integer month, Integer day) {
        LocalDate start = getDate(year, month, day);
        if (day == null) {
            return billRepository.getAllBillByDate(start, getLastDayOfMonth(start));
        }


        return billRepository.getAllBillByDate(start, start);
    }

    public LocalDate getDate(int year, int month, Integer day) {
        if (day == null) {
            // Trả về ngày đầu tháng
            return LocalDate.of(year, month, 1);
        } else {
            // Trả về ngày tháng của năm
            return LocalDate.of(year, month, day);
        }
    }


    public LocalDate getLastDayOfMonth(LocalDate date) {
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }


}
