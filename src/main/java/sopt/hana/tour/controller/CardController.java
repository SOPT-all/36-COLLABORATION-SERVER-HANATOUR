package sopt.hana.tour.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import sopt.hana.tour.common.response.ApiResponse;
import sopt.hana.tour.dto.response.CardResponse;
import sopt.hana.tour.service.CardService;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardController {

	private final CardService cardService;

	@Operation(summary = "카드 조회 API입니다.", description = "Home 페이지에서 카드조회에 대한 API입니다.")
	@GetMapping()
	public ResponseEntity<ApiResponse<List<CardResponse>>> getCards(){
		return ResponseEntity.ok(ApiResponse.success(200,"카드 정보에 대해 조회했습니다.",cardService.getCards()));
	}
}
