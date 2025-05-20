package sopt.hana.tour.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record MainSearchRequest(
    @NotBlank(message = "출발지는 필수입니다.")
    @Schema(description = "출발지", example = "서울")
    String departure,

    @NotBlank(message = "도착지는 필수입니다.")
    @Schema(description = "도착지", example = "부산")
    String arrival,

    @NotNull(message = "출발일시")
    @Schema(description = "출발일시", example = "2025-06-01T09:00:00")
    LocalDateTime departDate,

    @NotNull(message = "도착일시")
    @Schema(description = "도착일시", example = "2025-06-05T20:00:00")
    LocalDateTime arriveDate,

    @Schema(description = "페이지 크기", example = "20")
    Long size
)
{
    //pageSize = 20(default)
    @Schema(hidden = true)
    public Long getSizeOrDefault() {
        return size != null ? size : 20L;
    }
}
