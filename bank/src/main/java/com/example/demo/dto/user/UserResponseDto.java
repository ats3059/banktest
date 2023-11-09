package com.example.demo.dto.user;

import com.example.demo.domain.user.User;
import com.example.demo.util.CustomDateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

public class UserResponseDto {

    @Setter
    @Getter
    public static class LoginRespDto{
        private Long id;
        private String username;
        private String createdAt;

        public LoginRespDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.createdAt = CustomDateUtil.toStringFormat(user.getCreatedAt());
        }

    }

    @ToString
    @Getter
    @Setter
    public static class JoinRespDto{
        private Long id;
        private String username;
        private String fullName;

        public JoinRespDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.fullName = user.getFullName();
        }
    }
}
