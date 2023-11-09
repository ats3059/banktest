package com.example.demo.config.jwt;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.dto.user.UserRequestDto;
import com.example.demo.dto.user.UserRequestDto.LoginReqDto;
import com.example.demo.dto.user.UserResponseDto;
import com.example.demo.dto.user.UserResponseDto.LoginRespDto;
import com.example.demo.util.CustomResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        setFilterProcessesUrl("/api/login");
        this.authenticationManager = authenticationManager;
    }

    // Post : /api/login
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LoginReqDto loginReqDto = objectMapper.readValue(request.getInputStream(), LoginReqDto.class);

            // 강제 로그인
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword());

            // UserDetailsService, loadUserByUsername 호출
            // JWT를 쓴다 하더라도, 컨트롤러에 진입을 하면 시큐리티의 권한체크 , 인증체크의 도움을 받을 수 있게 세션을 만든다.
            // 이 세션의 유효기간은 request하고 , response하면 끝
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            return authentication;
        } catch (Exception e) {
            // authenticationEntryPoint에 걸린다.
            throw new InternalAuthenticationServiceException(e.getMessage());
        }
    }

    // return authentication 잘 작동하면 해당 메서드가 호출된다.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        LoginUser loginUser = (LoginUser) authResult.getPrincipal();
        String jwtToken = JwtProcess.create(loginUser);
        response.addHeader(JwtVO.HEADER, jwtToken);

        LoginRespDto loginRespDto = new LoginRespDto(loginUser.getUser());
        CustomResponseUtil.success(response,loginRespDto);
    }

}
