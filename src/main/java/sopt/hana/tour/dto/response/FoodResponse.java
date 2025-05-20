package sopt.hana.tour.dto.response;

public record FoodResponse(String type,
						   String title,
						   String tag1,
						   String tag2,
						   String tag3,
						   Long price,
						   String imageUrl) {
}
