package com.cg.bill;



import com.cg.bill.dto.BillDetailResult;
import com.cg.bill.dto.BillResult;
import com.cg.bill.dto.CreationBillParam;
import com.cg.exception.DataInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Bill;
import com.cg.model.Order;
import com.cg.model.TableOrder;
import com.cg.order.OrderRepository;
import com.cg.tableOrder.ITableOrderService;
import com.cg.tableOrder.TableOrderRepository;
import com.cg.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class BillServiceImpl implements IBillService {

    private final BillMapper billMapper;
    private final BillRepository billRepository;

    private final TableOrderRepository tableOrderRepository;

    private final OrderRepository orderRepository;
    private final ValidateUtils validateUtils;
    private final ITableOrderService tableOrderService;

    @Transactional
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Transactional
    public Bill findById(Long id) {
        return billRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found"));
    }


    @Transactional
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }


    @Transactional
    public void delete(Bill bill) {
    public List<BillResult> findAll() {
        List<Bill> entities = billRepository.findAll();
        return billMapper.toDTOList(entities);
    }

    @Transactional
    public BillDetailResult findBillById(String billIdStr) {
        if (!validateUtils.isNumberValid(billIdStr)) {
            throw new DataInputException("Mã lịch sử không hợp lệ");
        }
        Long billId = Long.parseLong(billIdStr);

        Bill entity = billRepository.findById(billId).orElseThrow(() -> {
            throw new DataInputException("Mã lịch sử không tồn tại");
        });

        return billMapper.toDTOBillDetai(entity);


    }


    @Transactional
    public List<BillResult> getAll() {
        return billMapper.toListBillResult(this.findAll());
    }
    @Transactional
    @Override
    public List<BillResult> findAllBillDTO() {
        return null;
    }
    @Transactional
    @Override
    public List<BillDetailResult> findBillById(Long billId) {
        return billRepository.findAllById(billId)
                .stream()
                .map(billMapper::toBillDetailResult)
                .collect(Collectors.toList());
    }
    @Transactional
    @Override
    public List<BillResult> findBillByCreatedAts(Date billDate) {
        return billRepository.findAllByCreatedAt(billDate)
                .stream()
                .map(billMapper::toBillResult)
                .collect(Collectors.toList());
    }
    @Transactional
    @Override
    public CreationBillParam createBill(Long tableId) {
        Order order = orderRepository.findByTableId(tableId).get();
        if (order.getPaid() == true) {
            throw new DataInputException("Bàn này đã thanh toán");
        }
        order.setPaid(true);
        TableOrder tableOrder = tableOrderRepository.findById(tableId)
                .orElseThrow(() -> new DataInputException("Bàn không đặt không thể thanh toán"));
        tableOrderRepository.save(tableOrder);

        Bill bill = new Bill();
        bill.setTotalAmount(order.getTotalAmount());
        bill.setOrder(order);
        bill = billRepository.save(bill);


        return billMapper.toCreationBillParam(bill);
    }
    @Transactional
    @Override
    public List<BillResult> getBillByDate(Integer year, Integer month, Integer day) {
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
