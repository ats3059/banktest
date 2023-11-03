package com.example.demo.dto.user;

import com.example.demo.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserResponseDto {

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
