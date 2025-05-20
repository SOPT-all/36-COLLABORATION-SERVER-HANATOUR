package sopt.hana.tour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sopt.hana.tour.dto.response.DiscountTimeDealsResponse;
import sopt.hana.tour.entity.Package;
import sopt.hana.tour.enums.DiscountType;
import sopt.hana.tour.repository.PackageRepository;

@RequiredArgsConstructor
@Service
public class DiscountTimeDealsService {

	private final PackageRepository packageRepository;

	public List<DiscountTimeDealsResponse> getTimeDeals(){

		List<Package> packages = packageRepository.findPackagesByDiscountType(DiscountType.TIMEDEAL);

		return packages.stream().map(pkg->
			new DiscountTimeDealsResponse(pkg.getTitle(),pkg.getTags().getTagName1(),pkg.getTags().getTagName2(),pkg.getTags().getTagName3(),
				pkg.getPrice(),pkg.getImageUrl())).toList();
	}

}
