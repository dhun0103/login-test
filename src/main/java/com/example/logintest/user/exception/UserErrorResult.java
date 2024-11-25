package com.example.logintest.user.exception;

import com.example.logintest.common.code.BaseErrorCode;
import com.example.logintest.common.dto.ErrorReasonDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorResult implements BaseErrorCode {
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "404", "존재하지 않는 유저입니다."),
    IS_DUPLICATE_NICKNAME(HttpStatus.CONFLICT, "409", "중복된 닉네임이 존재합니다."),
    NICKNAME_TOO_LONG(HttpStatus.CONFLICT, "409", "닉네임은 20자를 넘을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }
}
