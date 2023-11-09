package com.example.demo.util;

import com.example.demo.dto.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

public class CustomResponseUtil {
    private static final Logger log = LoggerFactory.getLogger(CustomResponseUtil.class);

    public static void success(HttpServletResponse resp , Object dto){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseDto<?> responseDto = new ResponseDto(1, "로그인성공", dto);
            String responseBody = objectMapper.writeValueAsString(responseDto);
            resp.setContentType("application/json; charset=utf-8");
            resp.setStatus(HttpStatus.OK.value());
            resp.getWriter().print(responseBody);
        } catch (Exception e) {
            log.error("서버파싱에러");
            throw new RuntimeException(e);
        }
    }

    public static void unAuthentication(HttpServletResponse resp , String msg){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseDto<?> responseDto = new ResponseDto(-1, "인증안됨", null);
            String responseBody = objectMapper.writeValueAsString(responseDto);
            resp.setContentType("application/json; charset=utf-8");
            resp.setStatus(HttpStatus.UNAUTHORIZED.value());
            resp.getWriter().print(responseBody);
        } catch (Exception e) {
            log.error("서버파싱에러");
            throw new RuntimeException(e);
        }
    }

}
