package sopt.hana.tour.dto.request;

import java.time.LocalDateTime;

public record PackageRequest(String title,
							 String type,
							 String hotelGrade,
							 String companion,
							 Long price,
							 Boolean includeFlight,
							 Boolean isGroup,
							 String description,
							 String discountType,
							 Tags tags,
							 TourCondition tourCondition,
							 Schedule schedule,
							 String imageUrl
							 ) {
	public record Tags(
		String tagName1,
		String tagName2,
		String tagName3
	){}

	public record TourCondition(
		boolean isFree,
		boolean isChoice,
		boolean isGuide,
		boolean isGuideFee,
		boolean isShop
	){}

	public record Schedule(
		LocalDateTime departDate,
		LocalDateTime arriveDate,
		String departure,
		String arrival
	) {}

}

