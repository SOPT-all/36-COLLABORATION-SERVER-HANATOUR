package sopt.hana.tour.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.hana.tour.common.response.ApiResponse;
import sopt.hana.tour.dto.request.MainSearchRequest;
import sopt.hana.tour.dto.response.MainSearchResponse;
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
  
	@PostMapping("/admin/posts")
	public ResponseEntity<ApiResponse<PackageResponse>> postPackage(@RequestBody PackageRequest request){
		return  ResponseEntity.ok(ApiResponse.success(201,"패키지가 작성되었습니다.",packageService.postPackage(request)));
	}
}
