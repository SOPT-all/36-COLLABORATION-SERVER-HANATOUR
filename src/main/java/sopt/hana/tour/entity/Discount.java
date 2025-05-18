package sopt.hana.tour.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.hana.tour.enums.DiscountType;

@Entity
@Table(name = "discount")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "package_id", unique = true)
    private Package pkg;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type", nullable = false)
    private DiscountType discountType;

    @Builder
    public Discount(Package pkg, DiscountType discountType) {
        this.pkg = pkg;
        this.discountType = discountType;
    }
}
