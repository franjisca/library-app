package com.group.libraryapp.service.user;


import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));
    }
    
    public List<UserResponse> userList(){
        return userRepository
                .findAll()
                .stream()
                .map(m -> new UserResponse(m.getId(), m.getName(),m.getAge()))
                .toList();
    } 
    
    public void updateUser(UserUpdateRequest request){
        User user = userRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        userRepository.save(user);
    }

    public void deleteUser(String name){
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);

    }

   /* public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }*/




}
