package com.cg.tableOrder;

import com.cg.model.TableOrder;
import com.cg.tableOrder.dto.TableOrderCreateReqDTO;
import com.cg.tableOrder.dto.TableOrderCreateResDTO;
import com.cg.tableOrder.dto.TableOrderDTO;
import com.cg.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITableOrderService extends IGeneralService<TableOrder,Long> {
    List<TableOrderDTO> findAllTableOrderDTO();

    TableOrderCreateResDTO createTableOrder(TableOrderCreateReqDTO tableOrderReqDTO);

    List<TableOrderDTO> findAllTablesWithoutSenderId(@Param("tableId") Long tableId);
}
