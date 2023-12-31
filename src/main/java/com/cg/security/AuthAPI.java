package com.cg.security;

import com.cg.exception.DataInputException;
import com.cg.exception.EmailExistsException;
import com.cg.model.JwtResponse;
import com.cg.model.Role;
import com.cg.model.User;
import com.cg.service.jwt.JwtService;
import com.cg.role.IRoleService;
import com.cg.user.IUserService;
import com.cg.user.UserMapper;
import com.cg.user.dto.UserParam;
import com.cg.utils.AppUtils;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthAPI {

<<<<<<< HEAD
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final IUserService userService;
    private final IRoleService roleService;
    private final AppUtils appUtils;
    private final UserMapper userMapper;


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserParam userParam, BindingResult bindingResult) {
=======

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;


    private final IUserService userService;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272


<<<<<<< HEAD
        Boolean existsByUsername = userService.existsByUsername(userParam.getUsername());
=======
    private final IRoleService roleService;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272


<<<<<<< HEAD
        Role role = roleService.findById(userParam.getRoleId());
        User entity = userMapper.toEntity(userParam);
        entity.setRole(role);
        try {
            userService.save(entity);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Account information is not valid, please check the information again");
        }
    }
=======
    private final AppUtils appUtils;


//    @PostMapping("/register")
//    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterReqDTO userRegisterReqDTO, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors())
//            return appUtils.mapErrorToResponse(bindingResult);
//
//        Boolean existsByUsername = userService.existsByUsername(userRegisterReqDTO.getUsername());
//
//        if (existsByUsername) {
//            throw new EmailExistsException("Account already exists");
//        }
//
//        Optional<Role> optRole = roleService.findById(userRegisterReqDTO.getRoleId());
//
//        if (!optRole.isPresent()) {
//            throw new DataInputException("Invalid account role");
//        }
//        try {
//            userService.save(userRegisterReqDTO.toUser(optRole.get()));
//
//            return new ResponseEntity<>(HttpStatus.CREATED);
//
//        } catch (DataIntegrityViolationException e) {
//            throw new DataInputException("Account information is not valid, please check the information again");
//        }
//    }
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtService.generateTokenLogin(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User currentUser = userService.getByUsername(user.getUsername());
            JwtResponse jwtResponse = new JwtResponse(
                    jwt,
                    currentUser.getId(),
                    userDetails.getUsername(),
                    currentUser.getUsername(),
                    userDetails.getAuthorities()
            );
            ResponseCookie springCookie = ResponseCookie.from("JWT", jwt)
                    .httpOnly(false)
                    .secure(false)
                    .path("/")
                    .maxAge(1000L * 60 * 60 * 24 * 30)
                    .domain("localhost")
                    .build();

            System.out.println(jwtResponse);

            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                    .body(jwtResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


}