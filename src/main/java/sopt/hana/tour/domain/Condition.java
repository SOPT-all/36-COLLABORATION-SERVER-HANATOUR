package sopt.hana.tour.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Getter
@Entity
public class Condition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long conditionId;

	@OneToOne
	@JoinColumn(name = "package_id")
	private Package packages;



}
