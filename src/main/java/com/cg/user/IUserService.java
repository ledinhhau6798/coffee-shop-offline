package com.cg.user;

import com.cg.model.User;
import com.cg.service.IGeneralService;
import com.cg.user.dto.UserParam;
import com.cg.user.dto.UserResult;
<<<<<<< HEAD
=======
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserResult> findAll();

    User findById(Long id);

    UserResult getById(Long id);

    UserResult create(UserParam creationParam);

<<<<<<< HEAD
    UserResult update(Long id, UserParam userParam);

    Boolean existsByUsername(String username);

    User save(User user);

    User getByUsername(String username);

    User findByUsername(String username);
=======
    UserResult update(Long id, UpdateUserParam updateParam);


    Optional<User> findByName(String username);

    User getByUsername(String username);

    UserDetails loadUserByUsername(String username);

    Boolean existsByUsername(String username);
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
}
