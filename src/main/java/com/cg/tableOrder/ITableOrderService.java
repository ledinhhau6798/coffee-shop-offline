package com.cg.tableOrder;

import com.cg.model.TableOrder;
import com.cg.tableOrder.DTO.TableOrderCreateReqDTO;
<<<<<<< HEAD
=======
import com.cg.tableOrder.DTO.TableOrderCreateResDTO;
>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a
import com.cg.tableOrder.DTO.TableOrderDTO;
import com.cg.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITableOrderService extends IGeneralService<TableOrder,Long> {
    List<TableOrderDTO> findAllTableOrderDTO();

    TableOrderDTO createTableOrder(TableOrderCreateReqDTO tableOrderReqDTO);

    List<TableOrderDTO> findAllTablesWithoutSenderId(@Param("tableId") Long tableId);
}
