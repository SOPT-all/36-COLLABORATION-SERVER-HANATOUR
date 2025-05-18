package sopt.hana.tour.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sopt.hana.tour.dto.request.PackageRequest;
import sopt.hana.tour.dto.response.PackageResponse;
import sopt.hana.tour.service.PackageService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PackageController {

	private final PackageService packageService;

	@PostMapping("/admin/posts")
	public ResponseEntity<PackageResponse> postPackage(PackageRequest request){
		return  ResponseEntity.ok(packageService.postPackage(request));
	}
}
