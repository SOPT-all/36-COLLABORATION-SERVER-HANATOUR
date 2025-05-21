package sopt.hana.tour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sopt.hana.tour.dto.response.CardResponse;
import sopt.hana.tour.entity.Card;
import sopt.hana.tour.repository.CardRepository;

@RequiredArgsConstructor
@Service
public class CardService {

	private final CardRepository cardRepository;


	public List<CardResponse> getCards(){
		List<Card> cards = cardRepository.findAll();
		return cards.stream()
			.map(card -> new CardResponse(card.getName(),card.getDescription(),card.getImageUrl())).toList();
	}
}
