package com.group.libraryapp.config;


import org.springframework.context.annotation.Configuration;

@Configuration // 클래스에 사용
public class UserConfiguration {


   /* @Bean // 메소드에 사용하고 해당 메소드가 리턴하는 객체를 bean으로 등록
    public UserRepository userRepository(JdbcTemplate jdbcTemplate){
        return new UserRepository(jdbcTemplate);
    }*/

    // @Repository와 @Service는 개발자가 직접 만든 클래스에
    // @Configuration + @Bean은 외부 라이브러리, 프레임워크에서 만든 클래스 등록할 때
    // @Component 개발자가 직접 만든 클래스
}
