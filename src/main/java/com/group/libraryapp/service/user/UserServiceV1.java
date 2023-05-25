package com.group.libraryapp.service.user;


import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {
    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void updateUser(UserUpdateRequest updateRequest){

        boolean isUserNotExist = userJdbcRepository.isUserNotExist(updateRequest.getId());

        if(isUserNotExist){
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserName(updateRequest);
    }

    public void deleteUser(String name){

        String readSql = "select * from users where name = ?";

        boolean isUserNotExist = userJdbcRepository.isUserNameExist(name);

        if(isUserNotExist){
            throw new IllegalArgumentException();
        }

        userJdbcRepository.deleteUser(name);

    }

    public List<UserResponse> userList(){
        return userJdbcRepository.userList();
    }

    public void saveUser(UserCreateRequest createRequest){
        userJdbcRepository.saveUser(createRequest);
    }
}
