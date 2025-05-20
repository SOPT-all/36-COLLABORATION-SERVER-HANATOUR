package sopt.hana.tour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sopt.hana.tour.dto.response.RecommendResponse;
import sopt.hana.tour.entity.Package;
import sopt.hana.tour.enums.DiscountType;
import sopt.hana.tour.repository.PackageRepository;

@RequiredArgsConstructor
@Service
public class RecommendService {

	private final PackageRepository packageRepository;

	public List<RecommendResponse> getRecommends(){
		List<Package> pkgs = packageRepository.findPackagesByDiscountType(DiscountType.RECOMMEND);

		return pkgs.stream()
			.map(pkg ->{
				return new RecommendResponse(pkg.getType(),pkg.getTitle()+ " "+pkg.getTags().getTagName1()+ " "+pkg.getTags().getTagName2()+ " "+pkg.getTags().getTagName3(),pkg.getPrice(),pkg.getImageUrl());
			}).toList();
	}
}
