package sopt.hana.tour.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "condition")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TourCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condition_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "package_id", nullable = false, unique = true)
    private Package pkg;

    @Column(name = "is_free", nullable = false)
    private Boolean isFree;

    @Column(name = "is_choice", nullable = false)
    private Boolean isChoice;

    @Column(name = "is_guide", nullable = false)
    private Boolean isGuide;

    @Column(name = "is_guide_fee", nullable = false)
    private Boolean isGuideFee;

    @Column(name = "is_shop", nullable = false)
    private Boolean isShop;

    @Builder
    public TourCondition(Package pkg, Boolean isFree, Boolean isChoice,
                         Boolean isGuide, Boolean isGuideFee, Boolean isShop) {
        this.pkg = pkg;
        this.isFree = isFree;
        this.isChoice = isChoice;
        this.isGuide = isGuide;
        this.isGuideFee = isGuideFee;
        this.isShop = isShop;
    }
}
