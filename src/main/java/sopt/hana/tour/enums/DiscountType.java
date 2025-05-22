package sopt.hana.tour.enums;

public enum DiscountType {
    TIMEDEAL("타임특가"),
    RUN("타임런"),
    JAPAN("일본"),
    SOUTH("동남아"),
    CHINA("중국"),
    EUROPE("유럽"),
    RECOMMEND("추천여행"),
    MYCOUNTRY("내나라"),
    NONE("할인없음");

    private final String discountName;

    DiscountType(String discountName){
        this.discountName = discountName;
    }

    }