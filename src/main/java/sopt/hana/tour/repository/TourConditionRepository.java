package sopt.hana.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.hana.tour.entity.TourCondition;

@Repository
public interface TourConditionRepository extends JpaRepository<TourCondition,Long> {
}
