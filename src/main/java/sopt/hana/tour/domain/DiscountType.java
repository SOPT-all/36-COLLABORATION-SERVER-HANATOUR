package sopt.hana.tour.domain;

public enum DiscountType {
	TIME_SALE("타임특가"),
	TIME_RUN("타임런");

	private final String discountName;

	DiscountType(String discountName){
		this.discountName = discountName;
	}

}
