package com.sparta.innovation03.dto;

public class ResponseDto<T> {
    private boolean success;
    private T data;
    private Error error;

    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto(true, data, (Error)null);
    }

    public static <T> ResponseDto<T> fail(String code, String message) {
        return new ResponseDto(false, (Object)null, new Error(code, message));
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getData() {
        return this.data;
    }

    public Error getError() {
        return this.error;
    }

    public ResponseDto(final boolean success, final T data, final Error error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    static class Error {
        private String code;
        private String message;

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public Error(final String code, final String message) {
            this.code = code;
            this.message = message;
        }
    }
}
