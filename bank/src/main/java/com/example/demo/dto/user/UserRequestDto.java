package com.example.demo.dto.user;

import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequestDto {

    @Setter
    @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }

    @Getter
    @Setter
    public static class JoinReqDto{
        // 영문, 숫자는 되고, 길이는 최소 2~20자 이내
        @Pattern(regexp = "^[a-zA-Z\\d]{2,20}$" , message = "영문/숫자 2~20자 이내로 작성해주세요")
        @NotEmpty // null 이거나, 공백일 수 없다.
        private String username;

        // 길이 4~20
        @Size(min = 4 , max = 20)
        @NotEmpty
        private String password;

        // 이메일 형식
        @NotEmpty
        @Email
        private String email;

        // 영어, 한글, 1~20
        @NotEmpty
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
