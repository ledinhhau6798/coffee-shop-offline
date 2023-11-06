package com.cg.user;


import com.cg.exception.ResourceNotFoundException;
import com.cg.model.User;
import com.cg.user.dto.CreationUserParam;
import com.cg.user.dto.UpdateUserParam;
import com.cg.user.dto.UserResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    @Transactional(readOnly = true)
    public List<UserResult> findAll() {
        List<User> entities = userRepository.findAll();
        return userMapper.toDTOList(entities);
    }

    @Override
    public User findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public UserResult getById(Long id) {
        return userMapper.toDTO(findById(id));
    }

    @Override
    @Transactional
    public UserResult create(CreationUserParam creationParam) {
        User entity = userMapper.toEntity(creationParam);
        entity = userRepository.save(entity);
        return userMapper.toDTO(entity);
    }

    @Override
    @Transactional
    public UserResult update(Long id, UpdateUserParam updateParam) {
        User entity = findById(id);
        userMapper.transferFields(entity, updateParam);
        entity.setPassword("d");
        //TODO:Kiem tra lai
//        entity = userRepository.save(entity);
        return userMapper.toDTO(entity);
    }

    @Override
    public Optional<User> findByName(String username) {
        return Optional.empty();
    }
}
