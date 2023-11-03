package com.example.demo.dto.user;

import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRequestDto {
    @Getter
    @Setter
    public static class JoinReqDto{
        // 유효성 검사
        private String username;
        private String password;
        private String email;
        private String fullName;

        public User toEntity(BCryptPasswordEncoder passwordEncoder) {
            return User.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .email(email)
                    .fullName(fullName)
                    .role(UserEnum.CUSTOMER)
                    .build();
        }
    }

}
