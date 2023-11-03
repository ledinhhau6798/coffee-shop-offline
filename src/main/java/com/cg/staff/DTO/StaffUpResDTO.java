package com.cg.staff.DTO;

import com.cg.model.StaffAvatar;
import com.cg.model.User;
import com.cg.locationRegion.DTO.LocationRegionUpResDTO;
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
public class StaffUpResDTO {
    private Long id;
    private String title;
    private String phone;
    private LocationRegionUpResDTO locationRegion;
    private StaffAvatar staffAvatar;
    private User user;
}