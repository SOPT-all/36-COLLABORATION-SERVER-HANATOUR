package sopt.hana.tour.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hana.tour.dto.request.MainSearchRequest;
import sopt.hana.tour.dto.response.MainSearchResponse;
import sopt.hana.tour.entity.Package;
import sopt.hana.tour.repository.PackageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainSearchService {

    private final PackageRepository packageRepository;

    public List<MainSearchResponse> searchPackages(MainSearchRequest request) {
        List<Package> packages = packageRepository.searchPackages(
                request.departure(),
                request.arrival(),
                request.departDate(),
                request.arriveDate()
        );

        Long size = request.getSizeOrDefault();

        return packages.stream()
                .map(MainSearchResponse::from)
                .limit(size)
                .toList();
    }
}
