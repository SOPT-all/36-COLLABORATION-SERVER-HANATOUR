package sopt.hana.tour.dto.response;

import java.time.LocalDateTime;

public record PackageResponse(String packageId,
							  String title,
							  String type,
							  String hotelGrade,
							  String companion,
							  long price,
							  boolean includeFlight,
							  boolean isGroup,
							  String description,
							  String discountType,
							  Tags tags,
							  TourCondition tourCondition,
							  Schedule schedules,
							  String imageUrl
) {

	public record Tags(
		String tagName1,
		String tagName2,
		String tagName3
	) {}

	public record TourCondition(
		boolean isFree,
		boolean isChoice,
		boolean isGuide,
		boolean isGuideFee,
		boolean isShop
	) {}

	public record Schedule(
		LocalDateTime departDate,
		LocalDateTime arriveDate,
		String departure,
		String arrival
	) {}
}

