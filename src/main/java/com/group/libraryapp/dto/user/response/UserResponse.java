package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.User;
import lombok.Data;
import lombok.Getter;


@Data
@Getter
public class UserResponse {

    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, User user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }
    public UserResponse(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
