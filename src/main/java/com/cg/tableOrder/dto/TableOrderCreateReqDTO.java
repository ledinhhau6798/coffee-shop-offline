package com.cg.tableOrder.dto;

import com.cg.model.TableOrder;
import com.cg.model.enums.ETableStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class TableOrderCreateReqDTO {
    private String title;


    public TableOrder toDTO() {
        return new TableOrder()
                .setId(null)
                .setTitle(title)
                .setStatus(ETableStatus.EMPTY)
                ;
    }


}
