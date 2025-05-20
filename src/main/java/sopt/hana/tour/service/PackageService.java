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
	private final S3Service s3Service;

	@Transactional
	public PackageResponse postPackage(PackageRequest request){

		Package pkg2 = Package.builder()
				.title(request.getTitle())
				.type(request.getType())
				.hotelGrade(request.getHotelGrade())
				.companion(request.getCompanion())
				.price(request.getPrice())
				.includeFlight(request.getIncludeFlight())
				.isGroup(request.getIsGroup())
				.description(request.getDescription())
				.build();

		String imageUrl = s3Service.uploadFile(request.getImage());
		pkg2.setImageUrl(imageUrl);

		TourCondition tourCondition = new TourCondition(pkg2,
				request.getTourCondition().getIsFree(),
				request.getTourCondition().getIsChoice(),
				request.getTourCondition().getIsGuide(),
				request.getTourCondition().getIsGuideFee(),
				request.getTourCondition().getIsShop());

		DiscountType discountType;
		if (request.getDiscountType().equals("타임특가")) {
			discountType = DiscountType.TIMEDEAL;
		}else if (request.getDiscountType().equals("타임런")) {
			discountType = DiscountType.RUN;
		}else if(request.getDiscountType().equals("일본")){
			discountType = DiscountType.JAPAN;
		}else if(request.getDiscountType().equals("동남아")){
			discountType = DiscountType.SOUTH;
		}else if(request.getDiscountType().equals("중국")){
			discountType = DiscountType.CHINA;
		}else if(request.getDiscountType().equals("유럽")){
			discountType = DiscountType.EUROPE;
		}else if(request.getDiscountType().equals("추천여행")) {
			discountType = DiscountType.RECOMMEND;
		}else if(request.getDiscountType().equals("내나라")) {
			discountType = DiscountType.MYCOUNTRY;
		}else {
			throw new IllegalArgumentException("잘못된 할인입력입니다.");
		}

		Discount discount;
		if(request.getDiscountTag1().isEmpty() && request.getDiscountTag1().isBlank()){
			discount = new Discount(pkg2, discountType);
		}else{
			discount = new Discount(pkg2,discountType,request.getDiscountTag1(), request.getDiscountTag2());
		}



		Tag tags = Tag.toEntity(pkg2, request);

		Schedule schedule = new Schedule(pkg2,
				request.getSchedules().getDepartDate(),
				request.getSchedules().getArriveDate(),
				request.getSchedules().getArrival(),
				request.getSchedules().getDeparture());

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

		return new PackageResponse(
				pkg2.getId().toString(),
				pkg2.getTitle(),
				pkg2.getType(),
				pkg2.getHotelGrade(),
				pkg2.getCompanion(),
				pkg2.getPrice(),
				pkg2.getIncludeFlight(),
				pkg2.getIsGroup(),
				pkg2.getDescription(),
				pkg2.getDiscount().getDiscountType().toString(),
				new PackageResponse.Tags(
						tags.getTagName1(),
						tags.getTagName2(),
						tags.getTagName3()
				),
				new PackageResponse.TourCondition(
						tourCondition.getIsFree(),
						tourCondition.getIsChoice(),
						tourCondition.getIsGuide(),
						tourCondition.getIsGuideFee(),
						tourCondition.getIsShop()
				),
				new PackageResponse.Schedule(
						schedule.getDepartDate(),
						schedule.getArriveDate(),
						schedule.getDeparture(),
						schedule.getArrival()
				),
				imageUrl
		);
	}
}
