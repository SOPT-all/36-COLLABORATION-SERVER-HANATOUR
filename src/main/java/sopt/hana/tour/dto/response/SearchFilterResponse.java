package sopt.hana.tour.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

public record SearchFilterResponse(
	int page,
	int size,
	List<SearchResponse> result
) {

	public static SearchFilterResponse from(Page<SearchResponse> page) {
		return new SearchFilterResponse(
			page.getNumber(),
			page.getSize(),
			page.getContent()
		);
	}

	public record SearchResponse(
		String packageId,
		String title,
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
		Schedule schedules,
		String imageUrl
	) {
		public record Tags(
			String tagName1,
			String tagName2,
			String tagName3
		) {}

		public record TourCondition(
			Boolean isFree,
			Boolean isChoice,
			Boolean isGuide,
			Boolean isGuideFee,
			Boolean isShop
		) {}

		public record Schedule(
			LocalDateTime departDate,
			LocalDateTime arriveDate,
			String departure,
			String arrival
		) {}
	}
}
