package sopt.hana.tour.dto.request;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;

public record PackageRequest(

							 @NotBlank String title,
							 @NotBlank String type,
							 @NotBlank String hotelGrade,
							 @NotBlank String companion,
							 @NonNull Long price,
							 @NonNull Boolean includeFlight,
							 @NonNull Boolean isGroup,
							 @NotBlank String description,
							 @NotBlank String discountType,
							 Tags tags,
							 TourCondition tourCondition,
							 Schedule schedule,
							 MultipartFile image
							 ) {


	public record Tags(
		String tagName1,
		String tagName2,
		String tagName3
	){}


	public record TourCondition(
		@NonNull
		boolean isFree,
		@NonNull
		boolean isChoice,
		@NonNull
		boolean isGuide,
		@NonNull
		boolean isGuideFee,
		@NonNull
		boolean isShop
	){}

	public record Schedule(
		LocalDateTime departDate,
		LocalDateTime arriveDate,
		String departure,
		String arrival
	) {}

}

