package sopt.hana.tour.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sopt.hana.tour.dto.response.FoodResponse;
import sopt.hana.tour.entity.Package;
import sopt.hana.tour.enums.DiscountType;
import sopt.hana.tour.repository.PackageRepository;

@RequiredArgsConstructor
@Service
public class FoodService {

	private final PackageRepository packageRepository;


	public List<FoodResponse> getFoods(String country){
		DiscountType discountType;
		 if(country.equals("일본")){
			discountType = DiscountType.JAPAN;
		}else if(country.equals("동남아")){
			discountType = DiscountType.SOUTH;
		}else if(country.equals("중국")){
			discountType = DiscountType.CHINA;
		}else if(country.equals("유럽")){
			discountType = DiscountType.EUROPE;
		}else {
			throw new IllegalArgumentException("잘못된 나라입력입니다.");
		}

		List<Package> pkgs = packageRepository.findPackagesByDiscountType(discountType);

		return pkgs.stream().
			map(pkg ->{
				return new FoodResponse(pkg.getType(),pkg.getTitle(),pkg.getTags().getTagName1(),pkg.getTags().getTagName2(),pkg.getTags().getTagName3(),pkg.getPrice(),pkg.getImageUrl());
		}).toList();

	}

}
