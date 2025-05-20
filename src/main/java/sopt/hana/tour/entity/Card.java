package sopt.hana.tour.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "card")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id")
	private Long cardId;

	@Column(name = "name",nullable = false)
	private String name;

	@Column(name = "description",nullable = false)
	private String description;

	@Column(name = "imageUrl",nullable = false)
	private String imageUrl;

	@Builder
	public Card(String name, String description,String imageUrl) {
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
	}
}
