package sopt.hana.tour.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import sopt.hana.tour.dto.request.PackageRequest;

@Getter
@Entity
@Table(name ="tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tagId;

	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "package_id",nullable = false)
	private Package pkg;

	@Setter
	private String tagName1;
	@Setter
	private String tagName2;
	@Setter
	private String tagName3;


	public Tag(){

	}

	public static Tag toEntity(Package pkg, PackageRequest request) {
		Tag tag = new Tag();
		tag.setPkg(pkg);

		if (request.tags().tagName1() != null && !request.tags().tagName1().isBlank()) {
			tag.setTagName1(request.tags().tagName1());
		}

		if (request.tags().tagName2() != null && !request.tags().tagName2().isBlank()) {
			tag.setTagName2(request.tags().tagName2());
		}

		if (request.tags().tagName3() != null && !request.tags().tagName3().isBlank()) {
			tag.setTagName3(request.tags().tagName3());
		}

		return tag;
	}
}
