package sopt.hana.tour.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.hana.tour.common.response.ApiResponse;
import sopt.hana.tour.dto.request.MainSearchRequest;
import sopt.hana.tour.dto.response.DiscountTimeDealsResponse;
import sopt.hana.tour.dto.response.MainSearchResponse;
import sopt.hana.tour.dto.response.SearchFilterResponse;
import sopt.hana.tour.service.DiscountRunService;
import sopt.hana.tour.service.DiscountTimeDealsService;
import sopt.hana.tour.service.FilterService;
import sopt.hana.tour.service.MainSearchService;
import sopt.hana.tour.dto.request.PackageRequest;
import sopt.hana.tour.dto.response.PackageResponse;
import sopt.hana.tour.service.PackageService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PackageController {

    private final MainSearchService mainSearchService;
    private final PackageService packageService;
    private final DiscountRunService discountRunService;
    private final FilterService filterService;
    private final DiscountTimeDealsService discountTimeDealsService;

    // 메인페이지 검색 API
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
    @GetMapping("/packages/discount-run")
    public ResponseEntity<ApiResponse<?>> getRunDiscountPackages() {
        return ResponseEntity.ok(
                ApiResponse.success(200, "할인런 패키지가 조회되었습니다.", discountRunService.getRunDiscountPackages())
        );
    }


    //관리자용 패키지 작성 API
	@PostMapping("/admin/posts")
	public ResponseEntity<ApiResponse<PackageResponse>> postPackage(@RequestBody PackageRequest request){
		return  ResponseEntity.ok(ApiResponse.success(201,"패키지가 작성되었습니다.",packageService.postPackage(request)));
	}

    //패키지 검색 API
    @GetMapping("/packages/filter")
    public ResponseEntity<ApiResponse<SearchFilterResponse>> getSearch(@RequestParam Long period,
        @PageableDefault(page = 0, size = 20)
        Pageable pageable){
        return ResponseEntity.ok(ApiResponse.success(200,"패키지 검색결과입니다.",filterService.getSearchFilter(period,pageable)));
    }

    //타음특가 조회 API
    @GetMapping("/packages/discount-timedeals")
    public ResponseEntity<ApiResponse<List<DiscountTimeDealsResponse>>> getTimeDeals(){
        return ResponseEntity.ok(ApiResponse.success(200,"타임특가 패키지가 조회되었습니다.",discountTimeDealsService.getTimeDeals()));
    }

}
