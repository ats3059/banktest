package com.example.demo.config.jwt;

/**
 *  SECRET 노축되면 안된다. (클라우드 - 환경변수 , 파일에 있는 것을 읽을 수도 있고 !!
 *  REFRESH_TOKEN (X) 이번 강의에서는 안함
 *
 */
public interface JwtVO {

    String SECRET = "메타코딩"; // HS256 (대칭키)
    int EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7; // 일주일
    String TOKEN_PREFIX = "Bearer ";
    String HEADER = "Authorization";

}
