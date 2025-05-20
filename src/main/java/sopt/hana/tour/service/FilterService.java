package sopt.hana.tour.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sopt.hana.tour.dto.response.SearchFilterResponse;
import sopt.hana.tour.entity.Package;
import sopt.hana.tour.repository.PackageRepository;

@RequiredArgsConstructor
@Service
public class FilterService {

	private final PackageRepository packageRepository;

	public SearchFilterResponse getSearchFilter(Long period, Pageable pageable){
		Page<Package> packages = packageRepository.findByPeriod(period, pageable);

		Page<SearchFilterResponse.SearchResponse> mapped = packages.map(pkg ->
			new SearchFilterResponse.SearchResponse(
				pkg.getId().toString(),
				pkg.getTitle(),
				pkg.getType(),
				pkg.getHotelGrade(),
				pkg.getCompanion(),
				pkg.getPrice(),
				pkg.getIncludeFlight(),
				pkg.getIsGroup(),
				pkg.getDescription(),
				pkg.getDiscount() != null ? pkg.getDiscount().getDiscountType().name() : null,
				new SearchFilterResponse.SearchResponse.Tags(
					pkg.getTags() != null && pkg.getTags().getTagName1() != null ? pkg.getTags().getTagName1().name() : null,
					pkg.getTags() != null && pkg.getTags().getTagName2() != null ? pkg.getTags().getTagName2().name() : null,
					pkg.getTags() != null && pkg.getTags().getTagName3() != null ? pkg.getTags().getTagName3().name() : null
				),
				new SearchFilterResponse.SearchResponse.TourCondition(
					pkg.getTourCondition() != null ? pkg.getTourCondition().getIsFree() : null,
					pkg.getTourCondition() != null ? pkg.getTourCondition().getIsChoice() : null,
					pkg.getTourCondition() != null ? pkg.getTourCondition().getIsGuide() : null,
					pkg.getTourCondition() != null ? pkg.getTourCondition().getIsGuideFee() : null,
					pkg.getTourCondition() != null ? pkg.getTourCondition().getIsShop() : null
				),
				new SearchFilterResponse.SearchResponse.Schedule(
					pkg.getSchedule() != null ? pkg.getSchedule().getDepartDate() : null,
					pkg.getSchedule() != null ? pkg.getSchedule().getArriveDate() : null,
					pkg.getSchedule() != null ? pkg.getSchedule().getDeparture() : null,
					pkg.getSchedule() != null ? pkg.getSchedule().getArrival() : null
				),
				pkg.getImageUrl()
			)
		);

		return new SearchFilterResponse(mapped.getNumber(), mapped.getSize(), mapped.getContent());
	}
}
