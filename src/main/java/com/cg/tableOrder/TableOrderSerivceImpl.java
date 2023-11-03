package com.cg.tableOrder;

import com.cg.model.TableOrder;
import com.cg.tableOrder.DTO.TableOrderCreateReqDTO;
import com.cg.tableOrder.DTO.TableOrderCreateResDTO;
import com.cg.tableOrder.DTO.TableOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
//@Component
@Transactional
public class TableOrderSerivceImpl implements ITableOrderService{

    @Autowired
    private TableOrderRepository tableOrderRepository;
    @Override
    public List<TableOrder> findAll() {
        return tableOrderRepository.findAll();
    }

    @Override
    public List<TableOrderDTO> findAllTableOrderDTO() {
        return tableOrderRepository.findAllTableOrderDTO();
    }

    @Override
    public Optional<TableOrder> findById(Long id) {
        return tableOrderRepository.findById(id);
    }

    @Override
    public TableOrder save(TableOrder tableOrder) {
        return tableOrderRepository.save(tableOrder);
    }

    @Override
    public TableOrderCreateResDTO createTableOrder(TableOrderCreateReqDTO tableOrderCreateReqDTO) {
        TableOrder tableOrder = tableOrderCreateReqDTO.toTableOrder();
        tableOrderRepository.save(tableOrder);

        TableOrderCreateResDTO tableOrderCreateResDTO = tableOrder.toTableOrderCreateResDTO();
        tableOrderCreateResDTO.setId(tableOrder.getId());
        return tableOrderCreateResDTO;
    }

    @Override
    public List<TableOrderDTO> findAllTablesWithoutSenderId(Long tableId) {
        return tableOrderRepository.findAllTablesWithoutSenderId(tableId);
    }

    @Override
    public void delete(TableOrder tableOrder) {

    }

    @Override
    public void deleteById(Long id) {

    }




}
