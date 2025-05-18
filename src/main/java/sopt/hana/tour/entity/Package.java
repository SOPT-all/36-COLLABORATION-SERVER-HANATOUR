package sopt.hana.tour.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "package")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "hotel_grade", nullable = false)
    private String hotelGrade;

    @Column(name = "companion", nullable = false)
    private String companion;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "include_flight", nullable = false)
    private Boolean includeFlight;

    @Column(name = "is_group", nullable = false)
    private Boolean isGroup;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @OneToOne(mappedBy = "pkg", cascade = CascadeType.ALL, orphanRemoval = true)
    private TourCondition tourCondition;

    @OneToOne(mappedBy = "pkg", cascade = CascadeType.ALL, orphanRemoval = true)
    private Discount discount;

    @OneToOne(mappedBy = "pkg", cascade = CascadeType.ALL, orphanRemoval = true)
    private Schedule schedule;

    @OneToMany(mappedBy = "pkg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tags = new ArrayList<>();

    @Builder
    public Package(String title, String type, String hotelGrade, String companion, Long price,
                   Boolean includeFlight, Boolean isGroup, String description, String imageUrl) {
        this.title = title;
        this.type = type;
        this.hotelGrade = hotelGrade;
        this.companion = companion;
        this.price = price;
        this.includeFlight = includeFlight;
        this.isGroup = isGroup;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
