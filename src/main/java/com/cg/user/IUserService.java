package com.cg.user;

import com.cg.model.User;
import com.cg.user.dto.CreationUserParam;
import com.cg.user.dto.UpdateUserParam;
import com.cg.user.dto.UserResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService {
    List<UserResult> findAll();

    User findById(Long id);

    UserResult getById(Long id);

    UserResult create(CreationUserParam creationParam);

    UserResult update(Long id, UpdateUserParam updateParam);
}
