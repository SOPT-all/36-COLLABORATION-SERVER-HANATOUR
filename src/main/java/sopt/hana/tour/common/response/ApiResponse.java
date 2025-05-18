package sopt.hana.tour.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {
    private final int status;
    private final String message;
    private final T result;

    public static <T> ApiResponse<T> success(int status, String message, T result) {
        return new ApiResponse<>(status, message, result);
    }

    public static <T> ApiResponse<T> fail(int status, String message) {
        return new ApiResponse<>(status, message, null);
    }
}