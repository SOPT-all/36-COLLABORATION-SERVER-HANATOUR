package sopt.hana.tour.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.hana.tour.entity.Package;

import java.time.LocalDateTime;
import java.util.List;

public interface PackageRepository extends JpaRepository<Package, Long> {

    @Query("""
        select distinct p from Package p
        join fetch p.schedule s
        left join fetch p.tourCondition
        left join fetch p.discount
        left join fetch p.tags
        where s.departure = :departure
          and s.arrival = :arrival
          and (:departDate is null or s.departDate >= :departDate)
          and (:arriveDate is null or s.arriveDate <= :arriveDate)
        """)
    List<Package> searchPackages(
            @Param("departure") String departure,
            @Param("arrival") String arrival,
            @Param("departDate") LocalDateTime departDate,
            @Param("arriveDate") LocalDateTime arriveDate
    );
}
