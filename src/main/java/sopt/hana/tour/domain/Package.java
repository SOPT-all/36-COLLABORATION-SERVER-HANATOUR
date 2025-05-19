package sopt.hana.tour.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name ="package")
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

	@Setter
	private String image_url;

	@Setter
	@OneToOne(mappedBy = "packages")
	private TourCondition tourCondition;

	@Setter
	@OneToOne(mappedBy = "packages")
	private Discount discount;

	public Package(){

	}

	@Builder
	public Package(String title, String type, String hotel_grade, String companion, Long price, Boolean include_flight,
		Boolean is_group, String description) {
		this.title = title;
		this.type = type;
		this.hotel_grade = hotel_grade;
		this.companion = companion;
		this.price = price;
		this.include_flight = include_flight;
		this.is_group = is_group;
		this.description = description;
	}
}
