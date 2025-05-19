package sopt.hana.tour.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record MainSearchRequest(
        @NotBlank(message = "출발지는 필수입니다.") String departure,
        @NotBlank(message = "도착지는 필수입니다.") String arrival,
        @NotNull(message = "출발일시는 필수입니다.") LocalDateTime departDate,
        @NotNull(message = "도착일시는 필수입니다.") LocalDateTime arriveDate,
        Long size
)
{
    //pageSize = 20(default)
    public Long getSizeOrDefault() {
        return size != null ? size : 20L;
    }
}
