package com.cg.bill;

import com.cg.bill.DTO.BillDetailDTO;
import com.cg.modelMapper.BaseMapper;
import com.cg.model.Bill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BillDetailMapper extends BaseMapper<BillDetailDTO, Bill> {

}
