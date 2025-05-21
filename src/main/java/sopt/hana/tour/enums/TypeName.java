package sopt.hana.tour.enums;

public enum TypeName {
    PACKAGE("패키지"),     // 패키지
    HONEYMOON("허니문"),   // 허니문
    GOLF("골프"),        // 골프
    CRUISE("크루즈"),      // 크루즈
    AIRTEL("에어텔"),      // 에어텔
    STANDARD("스탠다드"),    // 스탠다드
    PREMIUM("프리미엄");    // 프리미엄

    private final String tagName;
    TypeName(String tagName){this.tagName = tagName;
    }

    public static TypeName from(String name) {
        try {
            return TypeName.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new IllegalArgumentException("잘못된 태그값의 입력입니다.");
        }
    }
}
