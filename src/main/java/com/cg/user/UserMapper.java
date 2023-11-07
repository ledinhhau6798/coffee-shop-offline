package com.cg.user;

import com.cg.model.Role;
import com.cg.model.Staff;
import com.cg.model.User;
import com.cg.role.dto.RoleResult;
import com.cg.user.dto.UserParam;
import com.cg.user.dto.UserResult;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResult toDTO(User entity) {
<<<<<<< HEAD
        return new UserResult()
                .setId(entity.getId())
                .setUsername(entity.getUsername())
                .setPassword(entity.getPassword())
                .setRole(new RoleResult()
                        .setId(entity.getRole().getId())
                        .setName(entity.getRole().getName())
                        .setCode(entity.getRole().getCode())
                );
=======
        return entity.toDTO();
>>>>>>> 588abee6e8777b2a08792fc9f858fc14d93f3272
    }

    public User toEntity(UserParam creationParam) {
        return new User()
                .setUsername(creationParam.getUsername())
                .setPassword(creationParam.getPassword())
                ;
    }

    public void transferFields(User entity, UserParam updateParam) {
        entity.setUsername(updateParam.getUsername());
        entity.setRole(new Role().setId(updateParam.getRoleId()));
        entity.setUsername(updateParam.getUsername());
    }

    public List<UserResult> toDTOList(List<User> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public User toUser(Staff entity, Role role) {
        return new User()
                .setUsername(entity.getUser().getUsername())
                .setPassword(entity.getUser().getPassword())
                .setRole(role)
                ;
    }

}
