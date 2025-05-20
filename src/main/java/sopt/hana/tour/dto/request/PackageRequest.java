package sopt.hana.tour.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
public class PackageRequest {

	@NotBlank
	private String title;

	@NotBlank
	private String type;

	@NotBlank
	private String hotelGrade;

	@NotBlank
	private String companion;

	@NotNull
	private Long price;

	@NotNull
	private Boolean includeFlight;

	@NotNull
	private Boolean isGroup;

	@NotBlank
	private String description;

	@NotBlank
	private String discountType;

	@NotNull
	private Tags tags;

	@NotNull
	private TourCondition tourCondition;

	@NotNull
	private Schedule schedules;

	@NotNull
	private MultipartFile image;

	@Getter
	@Setter
	public static class Tags {
		private String tagName1;
		private String tagName2;
		private String tagName3;
	}

	@Getter
	@Setter
	public static class TourCondition {
		@NotNull
		private Boolean isFree;
		@NotNull
		private Boolean isChoice;
		@NotNull
		private Boolean isGuide;
		@NotNull
		private Boolean isGuideFee;
		@NotNull
		private Boolean isShop;
	}

	@Getter
	@Setter
	public static class Schedule {
		private LocalDateTime departDate;
		private LocalDateTime arriveDate;
		private String departure;
		private String arrival;
	}
}
