package sopt.hana.tour.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    private Package pkg;

    @Enumerated(EnumType.STRING)
    @Column(name = "tag_name1")
    private TagName tagName1;

    @Enumerated(EnumType.STRING)
    @Column(name = "tag_name2")
    private TagName tagName2;

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
}

