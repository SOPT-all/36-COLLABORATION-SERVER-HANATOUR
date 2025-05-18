package sopt.hana.tour.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Getter
@Entity
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long discountId;

	@OneToOne
	@JoinColumn(name = "package_id",nullable = true)
	private Package packages;

	@Enumerated(EnumType.STRING)
	private DiscountType discountType;
}
