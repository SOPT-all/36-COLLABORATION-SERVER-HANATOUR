package sopt.hana.tour.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sopt.hana.tour.dto.request.PackageRequest;
import sopt.hana.tour.enums.TagName;


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
    @Enumerated(EnumType.STRING)
    @Column(name = "tag_name1")
    private TagName tagName1;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tag_name2")
    private TagName tagName2;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tag_name3")
    private TagName tagName3;


    @Builder
    public Tag(Package pkg, TagName tagName1, TagName tagName2, TagName tagName3) {
        this.pkg = pkg;
        this.tagName1 = tagName1;
        this.tagName2 = tagName2;
        this.tagName3 = tagName3;
    }


    public static Tag toEntity(Package pkg, PackageRequest request) {
        Tag tag = new Tag();
        tag.setPkg(pkg);

        if (request.tags().tagName1() != null && !request.tags().tagName1().isBlank()) {
            tag.setTagName1(TagName.from(request.tags().tagName1()));
        }

        if (request.tags().tagName2() != null && !request.tags().tagName2().isBlank()) {
            tag.setTagName2(TagName.from(request.tags().tagName2()));
        }

        if (request.tags().tagName3() != null && !request.tags().tagName3().isBlank()) {
            tag.setTagName3(TagName.from(request.tags().tagName3()));
        }

        return tag;
    }

}

