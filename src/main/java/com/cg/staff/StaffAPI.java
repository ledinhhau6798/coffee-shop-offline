package com.cg.staff;

import com.cg.exception.DataInputException;
import com.cg.exception.EmailExistsException;
import com.cg.model.LocationRegion;
import com.cg.model.Role;
import com.cg.model.Staff;
import com.cg.model.User;
import com.cg.locationRegion.DTO.LocationRegionUpReqDTO;
import com.cg.staff.DTO.StaffCreReqDTO;
import com.cg.staff.DTO.StaffDTO;
import com.cg.staff.DTO.StaffUpReqDTO;
import com.cg.staff.DTO.StaffUpResDTO;
import com.cg.locationRegion.ILocationRegionService;
import com.cg.role.IRoleService;
<<<<<<< HEAD
=======
import com.cg.staff.IStaffService;
>>>>>>> 2b6552de4684ae2a975d0dabea22fad315181d7a
import com.cg.user.IUserService;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffAPI {
    @Autowired
    private IStaffService staffService;
    @Autowired
    private ValidateUtils validateUtils;
    @Autowired
    private AppUtils appUtils;
    @Autowired
    private IUserService userService;
    @Autowired
    private ILocationRegionService locationRegionService;
    @Autowired
    private IRoleService roleService;
    @GetMapping
    public ResponseEntity<?> getAllStaff() {
        return new ResponseEntity<>( staffService.findAllStaffDTO(), HttpStatus.OK);
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<?> getById(@PathVariable Long staffId) {
        Optional<Staff> optionalStaff = staffService.findByIdAndDeletedFalse(staffId);
        if (!optionalStaff.isPresent()) {
            throw new DataInputException("ID nhân viên không hợp lệ");
        }
        Staff staff = optionalStaff.get();
        StaffDTO staffDTO = staff.toStaffDTO();
        staffDTO.setStaffAvatar(staff.getStaffAvatar());
        return new ResponseEntity<>(staffDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@ModelAttribute StaffCreReqDTO staffCreReqDTO, BindingResult bindingResult) {

        new StaffCreReqDTO().validate(staffCreReqDTO,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Boolean existsByUsername = userService.existsByUsername(staffCreReqDTO.getUsername());

        if (existsByUsername) {
            throw new EmailExistsException("Tài khoản đã tồn tại");
        }
        Optional<Role> roleOptional  = roleService.findById(staffCreReqDTO.getRoleId());
        if(!roleOptional.isPresent()){
            throw new DataInputException("Role này Không tồn tại vui lòng xem lại");
        }
        Staff staff = staffService.create(staffCreReqDTO);
        StaffDTO staffCreReqDTO1 = staff.toStaffDTO();
        staffCreReqDTO1.setStaffAvatar(staff.getStaffAvatar());
        return new ResponseEntity<>(staffCreReqDTO1, HttpStatus.CREATED);
    }

    @PatchMapping("/{staffId}")
    public ResponseEntity<?> update(@PathVariable("staffId") String staffIdStr, StaffUpReqDTO staffUpReqDTO,BindingResult bindingResult) {

        if (!validateUtils.isNumberValid(staffIdStr)) {
            throw new DataInputException("Mã nhân viên không hợp lệ");
        }
        Long staffId = Long.parseLong(staffIdStr);
        Optional<Staff> staffOptional =  staffService.findByIdAndDeletedFalse(staffId);
        if (!staffOptional.isPresent()) {
            throw new DataInputException("Mã nhân viên không tồn tại");
        }
        User user = userService.findById(staffOptional.get().getUser().getId()).orElseThrow(() ->{
            throw new DataInputException("tài khoản mật khẩu không tồn tại");
        });
        new StaffUpReqDTO().validate(staffUpReqDTO,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }

        if (staffUpReqDTO.getStaffAvatar() == null) {

            Staff staff = staffUpReqDTO.toStaffUpReqDTO(staffId);

            Long locationRegionId = staffOptional.get().getLocationRegion().getId();
            LocationRegionUpReqDTO locationRegionUpReqDTO = staffUpReqDTO.getLocationRegion();
            LocationRegion locationRegion = locationRegionUpReqDTO.toLocationRegionUp(locationRegionId);
            locationRegionService.save(locationRegion);

            staff.setStaffAvatar(staffOptional.get().getStaffAvatar());
            staff.setUser(user);
            staff.setLocationRegion(locationRegion);

            staffService.save(staff);
            StaffUpResDTO staffUpResDTO = staff.toStaffUpResDTO();
            staffUpResDTO.setStaffAvatar(staff.getStaffAvatar());
            staffUpResDTO.setUser(staff.getUser());
            return new ResponseEntity<>(staffUpResDTO,HttpStatus.OK);
        }
        else {
            Staff staffUp = staffService.update(staffUpReqDTO,staffId);
            StaffUpResDTO staffUpResDTO = staffUp.toStaffUpResDTO();
            staffUpResDTO.setStaffAvatar(staffUp.getStaffAvatar());
            staffUpResDTO.setUser(staffUp.getUser());
            return new ResponseEntity<>(staffUpResDTO,HttpStatus.OK);
        }
    }


    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<?> deleteStaff(@PathVariable("staffId") String staffIdStr) {
        if (!validateUtils.isNumberValid(staffIdStr)) {
            throw new DataInputException("UserId không hợp lệ");
        }

        Long staffId = Long.valueOf(staffIdStr);

        Staff staff = staffService.findById(staffId).orElseThrow(() -> {
            throw new DataInputException("UserId không tồn tại");
        });

        staffService.deleteByIdTrue(staff);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/searchTitle/{keySearch}")
    public ResponseEntity<List<StaffDTO>> getStaffByTitle(@PathVariable("keySearch") String keySearch) {

        keySearch = '%' + keySearch + '%';

        List<StaffDTO> staffDTOS = staffService.findStaffByTitle(keySearch);

        if (staffDTOS.isEmpty()) {
            throw new DataInputException("Tên nhân viên không tồn tại");
        }

        return new ResponseEntity<>(staffDTOS, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<StaffDTO>> getAllStaffDTO(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        try {
            Page<StaffDTO> staffDTOS = staffService.findAllStaffDTOPage(PageRequest.of(page - 1, pageSize));

            if (staffDTOS.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(staffDTOS, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}