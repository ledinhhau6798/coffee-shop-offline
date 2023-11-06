package com.cg.user;

import com.cg.model.User;
import com.cg.user.dto.CreationUserParam;
import com.cg.user.dto.UpdateUserParam;
import com.cg.user.dto.UserResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResult toDTO(User entity) {
        return entity.toDTO();
    }

    public User toEntity(CreationUserParam creationParam) {
        return new User().setUsername(creationParam.getUsername());
    }

    public User toEntity(UpdateUserParam updateParam) {
        return null;//return new User().setId(1).setUsername("");
    }

    public User transferFields(User entity, UpdateUserParam updateParam) {
        return entity.setUsername(updateParam.getUsername());
    }


    public List<UserResult> toDTOList(List<User> entities) {
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
