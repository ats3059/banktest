package com.example.demo.web;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.user.UserRequestDto.JoinReqDto;
import com.example.demo.dto.user.UserResponseDto.JoinRespDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {
    private final UserService userService;

    // 인증이 필요없어야함 회원가입
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Validated JoinReqDto joinReqDto, BindingResult bindingResult) {
        JoinRespDto joinRespDto = userService.회원가입(joinReqDto);
        return new ResponseEntity<>(new ResponseDto<>(1, "회원가입 성공", joinRespDto), HttpStatus.CREATED);
    }
}
