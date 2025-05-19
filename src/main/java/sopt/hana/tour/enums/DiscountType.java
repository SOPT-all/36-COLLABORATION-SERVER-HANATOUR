package sopt.hana.tour.enums;

public enum DiscountType {
    TIMEDEAL("타임특가"),
    RUN("타임런");

    private final String discountName;

    DiscountType(String discountName){
        this.discountName = discountName;
    }

    }