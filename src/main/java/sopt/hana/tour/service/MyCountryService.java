package sopt.hana.tour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sopt.hana.tour.dto.response.MyCountryResponse;
import sopt.hana.tour.dto.response.RecommendResponse;
import sopt.hana.tour.entity.Package;
import sopt.hana.tour.enums.DiscountType;
import sopt.hana.tour.repository.PackageRepository;

@RequiredArgsConstructor
@Service
public class MyCountryService {

	private final PackageRepository packageRepository;

	public List<MyCountryResponse> getMyCountry(){
		List<Package> pkgs = packageRepository.findPackagesByDiscountType(DiscountType.MYCOUNTRY);

		return pkgs.stream()
			.map(pkg ->{
				return new MyCountryResponse(pkg.getTitle(),pkg.getDescription(),pkg.getImageUrl());
			}).toList();
	}

}
