package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.service.user.UserServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceV2 userService;

    public UserController(UserServiceV2 userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){

        userService.saveUser(request);

    }

    @GetMapping("/user")
    public List<UserResponse> userList(){
        return userService.userList();
    }


    // 예외처리 하기
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest updateRequest){

        userService.updateUser(updateRequest);

    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }


}
