package sopt.hana.tour.dto.response;

import sopt.hana.tour.entity.Package;
import sopt.hana.tour.entity.Tag;

public record DiscountRunResponse(
    String title,
    String tagName1,
    String tagName2,
    String tagName3,
    Long price,
    String imageUrl
) {
    public static DiscountRunResponse from(Package pkg) {
        Tag tag = pkg.getTags();

        return new DiscountRunResponse(
            pkg.getTitle(),
            tag != null && tag.getTagName1() != null ? tag.getTagName1().name() : null,
            tag != null && tag.getTagName2() != null ? tag.getTagName2().name() : null,
            tag != null && tag.getTagName3() != null ? tag.getTagName3().name() : null,
            pkg.getPrice(),
            pkg.getImageUrl()
        );
    }
}
