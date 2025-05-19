package sopt.hana.tour.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.hana.tour.dto.response.DiscountRunResponse;
import sopt.hana.tour.enums.DiscountType;
import sopt.hana.tour.repository.PackageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiscountRunService {

    private final PackageRepository packageRepository;

    public List<DiscountRunResponse> getRunDiscountPackages() {
        return packageRepository.findPackagesByDiscountType(DiscountType.RUN)
                .stream()
                .map(DiscountRunResponse::from)
                .toList();
    }
}
