package com.cg.user;

import com.cg.model.User;
import com.cg.user.dto.CreationUserParam;
import com.cg.user.dto.UpdateUserParam;
import com.cg.user.dto.UserResult;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserResult> findAll();

    User findById(Long id);

    UserResult getById(Long id);

    UserResult create(CreationUserParam creationParam);

    UserResult update(Long id, UpdateUserParam updateParam);


    Optional<User> findByName(String username);

    User getByUsername(String username);

    UserDetails loadUserByUsername(String username);

    Boolean existsByUsername(String username);
}
