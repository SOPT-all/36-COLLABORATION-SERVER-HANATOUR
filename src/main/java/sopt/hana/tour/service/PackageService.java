package sopt.hana.tour.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;


import sopt.hana.tour.dto.request.PackageRequest;
import sopt.hana.tour.dto.response.PackageResponse;
import sopt.hana.tour.entity.Discount;
import sopt.hana.tour.entity.Package;
import sopt.hana.tour.entity.Schedule;
import sopt.hana.tour.entity.Tag;

import sopt.hana.tour.entity.TourCondition;
import sopt.hana.tour.enums.DiscountType;
import sopt.hana.tour.repository.PackageRepository;
import sopt.hana.tour.repository.ScheduleRepository;
import sopt.hana.tour.repository.TourConditionRepository;
import sopt.hana.tour.repository.DiscountRepository;

import sopt.hana.tour.repository.TagRepository;

@RequiredArgsConstructor
@Service
public class PackageService {

	private final PackageRepository packageRepository;
	private final TourConditionRepository tourConditionRepository;
	private final DiscountRepository discountRepository;
	private final TagRepository tagRepository;
	private final ScheduleRepository scheduleRepository;

	@Transactional
	public PackageResponse postPackage(PackageRequest request){

		Package pkg2 = Package.builder()
			.title(request.title())
			.type(request.type())
			.hotelGrade(request.hotelGrade())
			.companion(request.companion())
			.price(request.price())
			.includeFlight(request.includeFlight())
			.isGroup(request.isGroup())
			.description(request.description())
			.build();

		TourCondition tourCondition = new TourCondition(pkg2,request.tourCondition().isFree(),
			request.tourCondition().isChoice(),request.tourCondition().isGuide(),request.tourCondition().isGuideFee(),request.tourCondition().isShop());

		DiscountType discountType;
		if(request.discountType().equals("타임특가")){
			discountType = DiscountType.TIMEDEAL;
		}else if(request.discountType().equals("타임런")){
			discountType = DiscountType.RUN;
		}else{
			throw new IllegalArgumentException("잘못된 discountType입니다.");
		}
		Discount discount = new Discount(pkg2,discountType);

		Tag tags = Tag.toEntity(pkg2,request);

		Schedule schedule = new Schedule(pkg2,request.schedules().departDate(),request.schedules().arriveDate(),
			request.schedules().arrival(),request.schedules().departure());

		Long period = schedule.calculatePeriod();

		pkg2.setPeriod(period);
		pkg2.setSchedule(schedule);
		pkg2.setTourCondition(tourCondition);
		pkg2.setDiscount(discount);
		pkg2.setTags(tags);


		packageRepository.save(pkg2);
		tourConditionRepository.save(tourCondition);
		discountRepository.save(discount);
		tagRepository.save(tags);
		scheduleRepository.save(schedule);

		return new PackageResponse(pkg2.getId().toString(),pkg2.getTitle(),pkg2.getType(),
			pkg2.getHotelGrade(),pkg2.getCompanion(),pkg2.getPrice(),pkg2.getIncludeFlight()
		,pkg2.getIsGroup(),pkg2.getDescription(),pkg2.getDiscount().getDiscountType().toString(),new PackageResponse.Tags(
			tags.getTagName1().toString(), tags.getTagName2().toString(), tags.getTagName3().toString()),new PackageResponse.TourCondition(tourCondition.getIsFree(),tourCondition.getIsChoice(),tourCondition.getIsGuide(),tourCondition.getIsGuideFee(),tourCondition.getIsShop()),
			new PackageResponse.Schedule(schedule.getDepartDate(),schedule.getArriveDate(),schedule.getDeparture(),schedule.getArrival()),"dummy");
	}

}
