package com.example.demo.dto;

public record ResponseDto<T>(Integer code, String msg, T data) {
}
