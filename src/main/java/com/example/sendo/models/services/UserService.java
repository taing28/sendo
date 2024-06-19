package com.example.sendo.models.services;

import com.example.sendo.models.dto.request.UserRequest;
import com.example.sendo.models.dto.response.UserPageDTO;
import com.example.sendo.models.entities.User;
import com.example.sendo.models.repo.UserRepo;
import com.example.sendo.models.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService implements IUserService {
    @Autowired
    private UserRepo _userRepo;
    @Autowired
    private PasswordEncoder _passwordEncoder;

    @Override
    public UserPageDTO findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = _userRepo.findAll(pageable);
        return UserPageDTO.toDTO(users);
    }

    @Override
    public User addNewUser(User user) throws Exception {
        if (findUserByEmail(user.getEmail()) != null) {
            throw new Exception("User is alr existed");
        }
        return _userRepo.save(user);
    }

    @Override
    public User updateNewUser(UserRequest request) throws Exception {
        if(!_userRepo.existsById(request.getId())){
            throw new Exception("User not existed");
        }
        if(findUserByEmail(request.getEmail()) != null){
            throw new Exception("Email already existed");
        }
        User oldUser = _userRepo.findById(request.getId()).get();
        oldUser.setEmail(request.getEmail());
        oldUser.setPassword(_passwordEncoder.encode(request.getPassword()));
        oldUser.setName(request.getName());
        oldUser.setPhone(request.getPhone());
        oldUser.setStatus(request.getStatus());
        return _userRepo.save(oldUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return _userRepo.findUsersByEmailEquals(email);
    }
}
