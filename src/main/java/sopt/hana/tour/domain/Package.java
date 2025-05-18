package sopt.hana.tour.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Getter
@Entity
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long package_id;

	private String title;

	private String type;

	private String hotel_grade;

	private String companion;

	private Long price;

	private Boolean include_flight;

	private Boolean is_group;

	private String description;

	private String image_url;


	@OneToOne(mappedBy = "packages")
	private Condition condition;

	@OneToOne(mappedBy = "packages")
	private Discount discount;


}
