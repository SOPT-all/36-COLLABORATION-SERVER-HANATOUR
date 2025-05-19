package sopt.hana.tour.dto.response;

import sopt.hana.tour.entity.Package;

public record DiscountRunResponse(
        String title,
        String tagName1,
        String tagName2,
        String tagName3,
        Long price,
        String imageUrl
) {
    public static DiscountRunResponse from(Package pkg) {
        var tags = pkg.getTags().isEmpty() ? null : pkg.getTags().get(0);
        return new DiscountRunResponse(
                pkg.getTitle(),
                tags != null && tags.getTagName1() != null ? tags.getTagName1().name() : null,
                tags != null && tags.getTagName2() != null ? tags.getTagName2().name() : null,
                tags != null && tags.getTagName3() != null ? tags.getTagName3().name() : null,
                pkg.getPrice(),
                pkg.getImageUrl()
        );
    }
}
