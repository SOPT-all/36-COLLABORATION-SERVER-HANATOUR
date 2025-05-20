package sopt.hana.tour.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sopt.hana.tour.dto.request.PackageRequest;

@Entity
@Table(name = "tag")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    private Package pkg;

    @Setter
    @Column(name = "tag_name1")
    private String tagName1;

    @Setter
    @Column(name = "tag_name2")
    private String tagName2;

    @Setter
    @Column(name = "tag_name3")
    private String tagName3;


    @Builder
    public Tag(Package pkg, String tagName1, String tagName2, String tagName3) {
        this.pkg = pkg;
        this.tagName1 = tagName1;
        this.tagName2 = tagName2;
        this.tagName3 = tagName3;
    }


    public static Tag toEntity(Package pkg, PackageRequest request) {
        Tag tag = new Tag();
        tag.setPkg(pkg);

        if (request.getTags() != null && request.getTags().getTagName1() != null && !request.getTags().getTagName1().isBlank()) {
            tag.setTagName1(request.getTags().getTagName1());
        }

        if (request.getTags() != null && request.getTags().getTagName2() != null && !request.getTags().getTagName2().isBlank()) {
            tag.setTagName2(request.getTags().getTagName2());
        }

        if (request.getTags() != null && request.getTags().getTagName3() != null && !request.getTags().getTagName3().isBlank()) {
            tag.setTagName3(request.getTags().getTagName3());
        }

        return tag;
    }


}

