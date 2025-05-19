package sopt.hana.tour.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "condition")
public class TourCondition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long conditionId;

	@OneToOne
	@JoinColumn(name = "package_id")
	private Package packages;

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

	public TourCondition(Package packages, Boolean isFree, Boolean isChoice, Boolean isGuideFee, Boolean isGuide,
		Boolean isShop) {
		this.packages = packages;
		this.isFree = isFree;
		this.isChoice = isChoice;
		this.isGuideFee = isGuideFee;
		this.isGuide = isGuide;
		this.isShop = isShop;
	}

	public TourCondition(Package packages) {
		this.packages = packages;
	}
	public TourCondition(){

	}
}
