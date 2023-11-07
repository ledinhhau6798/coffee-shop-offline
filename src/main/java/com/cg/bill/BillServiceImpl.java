package com.cg.bill;



import com.cg.bill.DTO.BillDetailResult;
import com.cg.bill.DTO.BillResult;
import com.cg.exception.DataInputException;
import com.cg.model.Bill;
import com.cg.model.Order;
import com.cg.model.TableOrder;
import com.cg.bill.dto.BillCreateResDTO;
import com.cg.bill.dto.BillDTO;
import com.cg.bill.dto.BillDetailDTO;
import com.cg.order.OrderRepository;
import com.cg.tableOrder.ITableOrderService;
import com.cg.tableOrder.TableOrderRepository;
import com.cg.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class BillServiceImpl implements IBillService {

//    private final BillDetailMapper billDetailMapper;
    private final BillMapper billMapper;



    private final BillRepository billRepository;

    private final TableOrderRepository tableOrderRepository;

    private final OrderRepository orderRepository;
    private final ValidateUtils validateUtils;
    private final ITableOrderService tableOrderService;

    @Override
    @Transactional
    public List<BillResult> findAll() {
        List<Bill> entitys = billRepository.findAll();
        return billMapper.toDTOList(entitys);
    }



    @Override
    public List<BillResult> findAllBillDTO() {
        return billRepository.findAll().stream().map(Bill::toBillDTO).collect(Collectors.toList());
    }

    @Override
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

    @Override
    public List<BillResult> findBillByCreatedAts(String eventDate) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date dateBill;
        try {
            dateBill = sdf.parse(eventDate);
        } catch (ParseException e) {
            throw new DataInputException("vui lòng nhập đúng kiểu năm/tháng/ngày");
        }
        return billRepository.findAllByCreatedAt(dateBill)
                .stream()
                .map(bill -> billMapper.toDTO(bill))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BillResult createBill(String tableIdStr) {

        if (!validateUtils.isNumberValid(tableIdStr)) {
            throw new DataInputException("Mã bàn không hợp lệ");
        }

        Long tableId = Long.parseLong(tableIdStr);
        tableOrderService.findById(tableId).orElseThrow(() ->{
            throw new DataInputException("Mã bàn không tồn tại");
        });

        Order order = orderRepository.findByTableId(tableId).get();
        if (order.getPaid() == true) {
            throw new DataInputException("Bàn này đã thanh toán");
        }
        order.setPaid(true);
        TableOrder tableOrder = tableOrderRepository.findById(tableId)
                .orElseThrow(() -> new DataInputException("Bàn không đặt không thể thanh toán"));
        tableOrderRepository.save(tableOrder);

        Bill entity = new Bill();
        entity.setTotalAmount(order.getTotalAmount());
        entity.setOrder(order);
        entity = billRepository.save(entity);
        return billMapper.toDTO(entity);
    }

    @Override
    public List<BillResult> getBillByDate(Integer year, Integer month, Integer day) {
        LocalDate start = getDate(year, month, day);
        if (day == null) {
            return billRepository.getAllBillByDate(start, getLastDayOfMonth(start))
                    .stream().map(billMapper::toDTO).collect(Collectors.toList());
        }


        return billRepository.getAllBillByDate(start, start)
                .stream().map(billMapper::toDTO).collect(Collectors.toList());
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
