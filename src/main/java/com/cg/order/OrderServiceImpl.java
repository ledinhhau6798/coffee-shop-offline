package com.cg.order;

<<<<<<< HEAD
import com.cg.exception.ResourceNotFoundException;
import com.cg.order.dto.OrderCreReqDTO;
import com.cg.order.dto.OrderUpChangeToTableReqDTO;
import com.cg.order.dto.OrderUpChangeToTableResDTO;
import com.cg.order.dto.OrderUpReqDTO;
=======
import com.cg.order.dto.*;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import com.cg.exception.DataInputException;
import com.cg.model.*;

import com.cg.orderDetail.dto.OrderDetailProductUpResDTO;

import com.cg.model.enums.ETableStatus;
import com.cg.orderDetail.OrderDetailMapper;
import com.cg.orderDetail.OrderDetailRepository;
import com.cg.orderDetail.dto.OrderDetailResult;
import com.cg.orderDetail.dto.UpdateOrderDetaiParam;
import com.cg.product.IProductService;
import com.cg.product.ProductRepository;
import com.cg.staff.StaffRepository;
<<<<<<< HEAD
import com.cg.tableOrder.TableOrderMapper;
import com.cg.tableOrder.TableOrderRepository;
=======
import com.cg.tableOrder.ITableOrderService;
import com.cg.tableOrder.TableOrderRepository;
import com.cg.user.UserServiceImpl;
import com.cg.utils.AppUtils;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
<<<<<<< HEAD
@Transactional
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final StaffRepository staffRepository;
    private final TableOrderRepository tableOrderRepository;
    private final ProductRepository productRepository;
    private final TableOrderMapper tableOrderMapper;

=======
public class OrderServiceImpl implements IOrderService{


    private final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

    private final StaffRepository staffRepository;

    private final TableOrderRepository tableOrderRepository;

    private final ProductRepository productRepository;

    private final AppUtils appUtils;

    private final UserServiceImpl userService;

    private final ITableOrderService tableOrderService;

    private final IOrderService orderService;
    private final OrderDetailMapper orderDetailMapper;
    private final IProductService productService;

    @Override
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public Order findByTableId(Long tableId) {
        return orderRepository.findByTableId(tableId).orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public List<Order> findByTableOrderAndPaid(TableOrder tableOrder, Boolean paid) {
        return orderRepository.findByTableOrderAndPaid(tableOrder, paid);
    }

    @Override
    public OrderDetailResult creOrder(CreationOrderParam creationOrderParam) {
        String username = appUtils.getPrincipalUsername();
        Optional<User> userOptional = userService.findByName(username);

        TableOrder tableOrder = tableOrderService.findById(creationOrderParam.getTableId()).orElseThrow(() -> {
            throw new DataInputException("Bàn không tồn tại");
        });

        List<Order> orders = orderService.findByTableOrderAndPaid(tableOrder, false);

        if (orders.size() > 0) {
            throw new DataInputException("Bàn này đang có hoá đơn, vui lòng kiểm tra lại thông tin");
        }
        Order order = new Order();
<<<<<<< HEAD
        Staff staff = staffRepository.findStaffByUserAndDeletedIsFalse(user);
        order.setStaff(staff);
=======
        Optional<Staff> optionalStaff = staffRepository.findByUserAndDeletedIsFalse(userOptional.get());
        order.setStaff(optionalStaff.get());
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
        order.setTableOrder(tableOrder);
        order.setTotalAmount(BigDecimal.ZERO);
        order.setPaid(false);
        orderRepository.save(order);

        tableOrder.setStatus(ETableStatus.BUSY);
        tableOrderRepository.save(tableOrder);

<<<<<<< HEAD
        Product product = productRepository.findById(orderCreReqDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found!"));
=======
        Product product = productRepository.findById(creationOrderParam.getProductId()).orElseThrow(() -> {
            throw new DataInputException("Sản phẩm này không tồn tại vui lòng xem lại");
        });
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

        OrderDetail orderDetail = new OrderDetail();

        Long quantity = creationOrderParam.getQuantity();
        BigDecimal price = product.getPrice();
        BigDecimal amount = price.multiply(BigDecimal.valueOf(quantity));

        orderDetail.setProduct(product);
        orderDetail.setQuantity(quantity);
        orderDetail.setPrice(price);
        orderDetail.setAmount(amount);
        orderDetail.setNote(creationOrderParam.getNote());
        orderDetail.setOrder(order);

        orderDetailRepository.save(orderDetail);

        order.setTotalAmount(amount);
        orderRepository.save(order);
<<<<<<< HEAD

        OrderDetailCreResDTO orderDetailCreResDTO = new OrderDetailCreResDTO();
        orderDetailCreResDTO.setOrderDetailId(orderDetail.getId());
        orderDetailCreResDTO.setTable(tableOrderMapper.toDTO(tableOrder));
        orderDetailCreResDTO.setProductId(product.getId());
        orderDetailCreResDTO.setTitle(product.getTitle());
        orderDetailCreResDTO.setPrice(price);
        orderDetailCreResDTO.setQuantity(quantity);
        orderDetailCreResDTO.setAmount(amount);
        orderDetailCreResDTO.setNote(orderDetail.getNote());
        orderDetailCreResDTO.setTotalAmount(amount);
        orderDetailCreResDTO.setAvatar(product.getProductAvatar().toProductAvatarDTO());

        return orderDetailCreResDTO;
=======
        return orderDetailMapper.toDTO(orderDetail);
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    }

    @Override
    public UpdateOrderDetaiParam upOrderDetail(OrderUpReqDTO orderUpReqDTO) {

        String username = appUtils.getPrincipalUsername();
        Optional<User> userOptional = userService.findByName(username);

        TableOrder tableOrder = tableOrderService.findById(orderUpReqDTO.getTableId()).orElseThrow(() -> {
            throw new DataInputException("Bàn không tồn tại");
        });

         Product product = productService.findById(orderUpReqDTO.getProductId()).orElseThrow(() -> {
            throw new DataInputException("Sản phẩm không tồn tại");
        });

        List<Order> orders = orderService.findByTableOrderAndPaid(tableOrder, false);

        if (orders.size() == 0) {
            throw new DataInputException("Bàn này không có hoá đơn, vui lòng kiểm tra lại thông tin");
        }

        if (orders.size() > 1) {
            throw new DataInputException("Lỗi hệ thống, vui lòng liên hệ ADMIN để kiểm tra lại dữ liệu");
        }

        Order order = orders.get(0);
        List<OrderDetail> orderDetails = orderDetailRepository.findAllByOrder(order);
        OrderDetail orderDetail = new OrderDetail();

        if (orderDetails.size() == 0) {
            throw new DataInputException("Hoá đơn bàn này chưa có mặt hàng nào, vui lòng liên hệ ADMIN để kiểm tra lại dữ liệu");
        }

        Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findByProductIdAndOrderIdAndNote(orderUpReqDTO.getProductId(), order.getId(), orderUpReqDTO.getNote());

        if (orderDetailOptional.isEmpty()) {
            Long quantity = orderUpReqDTO.getQuantity();
            BigDecimal price = product.getPrice();
            BigDecimal amount = price.multiply(BigDecimal.valueOf(quantity));

            orderDetail.setProduct(product);
            orderDetail.setOrder(order);
            orderDetail.setPrice(product.getPrice());
            orderDetail.setQuantity(quantity);
            orderDetail.setAmount(amount);
            orderDetail.setNote(orderUpReqDTO.getNote());
            orderDetailRepository.save(orderDetail);

            BigDecimal newTotalAmount = getOrderTotalAmount(order.getId());
            order.setTotalAmount(newTotalAmount);
            orderRepository.save(order);
        } else {
            orderDetail = orderDetailOptional.get();
            long newQuantity = orderDetail.getQuantity() + orderUpReqDTO.getQuantity();
            BigDecimal price = orderDetail.getPrice();
            BigDecimal newAmount = price.multiply(BigDecimal.valueOf(newQuantity));
            orderDetail.setQuantity(newQuantity);
            orderDetail.setAmount(newAmount);
            orderDetailRepository.save(orderDetail);

            BigDecimal newTotalAmount = getOrderTotalAmount(order.getId());
            order.setTotalAmount(newTotalAmount);
            orderRepository.save(order);
        }

        List<OrderDetailProductUpResDTO> newOrderDetails = orderDetailRepository.findAllOrderDetailProductUpResDTO(order.getId());

<<<<<<< HEAD
        OrderDetailUpResDTO orderDetailUpResDTO = new OrderDetailUpResDTO();
        orderDetailUpResDTO.setTable(tableOrderMapper.toDTO(order.getTableOrder()));
        orderDetailUpResDTO.setProducts(newOrderDetails);
        orderDetailUpResDTO.setTotalAmount(order.getTotalAmount());

        return orderDetailUpResDTO;

=======
//        UpdateOrderDetaiParam updateOrderDetaiParam = new UpdateOrderDetaiParam();
//        updateOrderDetaiParam.setTable(order.getTableOrder().toTableOrderResDTO());
//        updateOrderDetaiParam.setProducts(newOrderDetails);
//        updateOrderDetaiParam.setTotalAmount(order.getTotalAmount());
//
//        return updateOrderDetaiParam;
        return orderDetailMapper.toDTO(order,newOrderDetails);
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    }

    @Override
    public OrderUpChangeToTableResDTO changeToTable(OrderUpChangeToTableReqDTO orderUpChangeToTableReqDTO, User user) {
        Order orderBusy = orderRepository.findByTableId(orderUpChangeToTableReqDTO.getTableIdBusy()).get();

        TableOrder emptyTable = tableOrderRepository.findById(orderUpChangeToTableReqDTO.getTableIdEmpty()).get();
        emptyTable.setStatus(ETableStatus.BUSY);
        tableOrderRepository.save(emptyTable);

        orderBusy.setTableOrder(emptyTable);
        orderRepository.save(orderBusy);

        TableOrder busyTable = tableOrderRepository.findById(orderUpChangeToTableReqDTO.getTableIdBusy()).get();
        busyTable.setStatus(ETableStatus.EMPTY);
        tableOrderRepository.save(busyTable);

        List<OrderDetailProductUpResDTO> newOrderDetails = orderDetailRepository.findAllOrderDetailProductUpResDTO(orderBusy.getId());

        OrderUpChangeToTableResDTO orderUpChangeToTableResDTO = new OrderUpChangeToTableResDTO();
        orderUpChangeToTableResDTO.setTableOrder(
                tableOrderMapper.toDTO(orderBusy.getTableOrder()));
        orderUpChangeToTableResDTO.setTotalAmount(orderBusy.getTotalAmount());
        orderUpChangeToTableResDTO.setProducts(newOrderDetails);


        return orderUpChangeToTableResDTO;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void deleteById(Long id) {

    }

    public BigDecimal getOrderTotalAmount(Long orderId) {
        return orderRepository.getOrderTotalAmount(orderId);
    }
}
