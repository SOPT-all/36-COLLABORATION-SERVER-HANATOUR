package sopt.hana.tour.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.hana.tour.common.response.ApiResponse;
import sopt.hana.tour.dto.request.MainSearchRequest;
import sopt.hana.tour.dto.response.DiscountTimeDealsResponse;
import sopt.hana.tour.dto.response.FoodResponse;
import sopt.hana.tour.dto.response.MainSearchResponse;
import sopt.hana.tour.dto.response.RecommendResponse;
import sopt.hana.tour.dto.response.SearchFilterResponse;
import sopt.hana.tour.service.DiscountRunService;
import sopt.hana.tour.service.DiscountTimeDealsService;
import sopt.hana.tour.service.FilterService;
import sopt.hana.tour.service.FoodService;
import sopt.hana.tour.service.MainSearchService;
import sopt.hana.tour.dto.request.PackageRequest;
import sopt.hana.tour.dto.response.PackageResponse;
import sopt.hana.tour.service.PackageService;
import lombok.extern.slf4j.Slf4j;
import sopt.hana.tour.service.RecommendService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PackageController {

    private final MainSearchService mainSearchService;
    private final PackageService packageService;
    private final DiscountRunService discountRunService;
    private final FilterService filterService;
    private final DiscountTimeDealsService discountTimeDealsService;
	private final FoodService foodService;
	private final RecommendService recommendService;
    // 메인페이지 검색 API
	@Operation(summary = "Home 페이지에서 검색하는 API입니다." , description = "Home 페이지에서 검색을 할 때 사용하는 API입니다.")

    @PostMapping("/packages/search")
    public ResponseEntity<ApiResponse<List<MainSearchResponse>>> searchPackages(
            @RequestBody @Valid MainSearchRequest request
    ) {
        List<MainSearchResponse> result = mainSearchService.searchPackages(request);
        return ResponseEntity.ok(
                ApiResponse.success(200, "패키지 검색결과입니다.", result)
        );
    }

    //할인런 조회 API
	@Operation(summary = "할인런 조회 API입니다.", description = "Home 페이지에서 할인런을 조회할 때 사용하는 API입니다.")

    @GetMapping("/packages/discount-run")
    public ResponseEntity<ApiResponse<?>> getRunDiscountPackages() {
        return ResponseEntity.ok(
                ApiResponse.success(200, "할인런 패키지가 조회되었습니다.", discountRunService.getRunDiscountPackages())
        );
    }


    //관리자용 패키지 작성 API
	@Operation(summary = "관리자용으로 데이터를 추가하기 위해 사용하는 API입니다.")
	@PostMapping("/admin/posts")
	public ResponseEntity<ApiResponse<PackageResponse>> postPackage(@RequestBody PackageRequest request){
		return  ResponseEntity.ok(ApiResponse.success(201,"패키지가 작성되었습니다.",packageService.postPackage(request)));
	}

    //패키지 검색 API
    @Operation(summary = "여행기간으로 패키지를 검색하는 API입니다.",description = "여행기간을 입력받고, pageable이기에 page 값과 size값을 입력받아서 제공해줍니다. default값으로 page = 0, size = 0입니다.")
    @GetMapping("/packages/filter")
    public ResponseEntity<ApiResponse<SearchFilterResponse>> getSearch(@RequestParam Long period,
		@ParameterObject @PageableDefault(page = 0, size = 20)
        Pageable pageable){
        return ResponseEntity.ok(ApiResponse.success(200,"패키지 검색결과입니다.",filterService.getSearchFilter(period,pageable)));
    }

    //타임특가 조회 API
    @Operation(summary = "타임특가 조회 API입니다.", description = "Home 페이지에서 타임특가를 조회할 때 사용하는 API입니다.")
    @GetMapping("/packages/discount-timedeals")
    public ResponseEntity<ApiResponse<List<DiscountTimeDealsResponse>>> getTimeDeals(){
        return ResponseEntity.ok(ApiResponse.success(200,"타임특가 패키지가 조회되었습니다.",discountTimeDealsService.getTimeDeals()));
    }


	//미식탐방 조회 API
	@Operation(summary = "미식탐방 조회 API입니다.", description = "Home 페이지에서 미식탐방을 조회할 때 사용하는 API입니다.")
	@GetMapping("/packages")
	public ResponseEntity<ApiResponse<List<FoodResponse>>> getFoods(@RequestParam String country){

		return ResponseEntity.ok(ApiResponse.success(200,country + "미식탐방이 조회되었습다.",foodService.getFoods(country)));
	}

	//추천 여행 조회 API
	@Operation(summary = "미식탐방 조회 API입니다.", description = "Home 페이지에서 미식탐방을 조회할 때 사용하는 API입니다.")
	public ResponseEntity<ApiResponse<List<RecommendResponse>>> getRecommends(){
		return ResponseEntity.ok(ApiResponse.success(200,"추천여행에 대해서 조회하였습니다.",recommendService.getRecommends()));
	}

}
