package com.group.libraryapp.repository.user;


import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// @Repository

@Repository
public class UserJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id){
        String readSql = "select * from users where id = ?";

        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();

    }

    public boolean isUserNameExist(String name){
        String readSql = "select * from users where name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    public void updateUserName(UserUpdateRequest updateRequest){
        // 없는 유저를 업데이트 하거나 삭제하려 해도 200이 나오는 문제
        String sql = "update users set name = ? where id = ?";
        jdbcTemplate.update(sql, updateRequest.getName(), updateRequest.getId());

    }

    public void deleteUser(String name){

        String sql = "delete from users where name = ?";
        jdbcTemplate.update(sql, name);

    }

    public List<UserResponse> userList() {
        String sql = "select * from users";

        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                return new UserResponse(id, name, age);
            }
        });
    }

    public void saveUser(UserCreateRequest createRequest) {
        User user = new User(createRequest.getName(), createRequest.getAge());

        String sql = "insert into users (name, age) values (? , ?)";

        jdbcTemplate.update(sql, createRequest.getName(), createRequest.getAge());
    }
}
