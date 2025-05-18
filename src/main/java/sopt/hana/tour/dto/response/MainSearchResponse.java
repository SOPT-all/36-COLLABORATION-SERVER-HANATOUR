package sopt.hana.tour.dto.response;

import sopt.hana.tour.entity.Package;

import java.time.LocalDateTime;

public record MainSearchResponse(
        Long packageId,
        String title,
        String type,
        String hotelGrade,
        String companion,
        Long price,
        Boolean includeFlight,
        Boolean isGroup,
        String description,
        String discountType,
        TagDto tags,
        TourConditionDto tourCondition,
        ScheduleDto schedules,
        String imageUrl
) {

    public record TagDto(
            String tagName1,
            String tagName2,
            String tagName3
    ) {}

    public record TourConditionDto(
            Boolean isFree,
            Boolean isChoice,
            Boolean isGuide,
            Boolean isGuideFee,
            Boolean isShop
    ) {}

    public record ScheduleDto(
            LocalDateTime departDate,
            LocalDateTime arriveDate,
            String departure,
            String arrival
    ) {}

    public static MainSearchResponse from(Package pkg) {
        TagDto tagDto = null;
        if (pkg.getTags() != null && !pkg.getTags().isEmpty()) {
            var tag = pkg.getTags().get(0);
            tagDto = new TagDto(
                    tag.getTagName1() != null ? tag.getTagName1().name() : null,
                    tag.getTagName2() != null ? tag.getTagName2().name() : null,
                    tag.getTagName3() != null ? tag.getTagName3().name() : null
            );
        }

        // 조건: 널 체크 후 생성
        TourConditionDto tourConditionDto = null;
        if (pkg.getTourCondition() != null) {
            tourConditionDto = new TourConditionDto(
                    pkg.getTourCondition().getIsFree(),
                    pkg.getTourCondition().getIsChoice(),
                    pkg.getTourCondition().getIsGuide(),
                    pkg.getTourCondition().getIsGuideFee(),
                    pkg.getTourCondition().getIsShop()
            );
        }

        // 일정: 널 체크 후 생성
        ScheduleDto scheduleDto = null;
        if (pkg.getSchedule() != null) {
            scheduleDto = new ScheduleDto(
                    pkg.getSchedule().getDepartDate(),
                    pkg.getSchedule().getArriveDate(),
                    pkg.getSchedule().getDeparture(),
                    pkg.getSchedule().getArrival()
            );
        }

        return new MainSearchResponse(
                pkg.getId(),
                pkg.getTitle(),
                pkg.getType(),
                pkg.getHotelGrade(),
                pkg.getCompanion(),
                pkg.getPrice(),
                pkg.getIncludeFlight(),
                pkg.getIsGroup(),
                pkg.getDescription(),
                pkg.getDiscount() != null ? pkg.getDiscount().getDiscountType().name() : null,
                tagDto,
                tourConditionDto,
                scheduleDto,
                pkg.getImageUrl()
        );
    }
}
