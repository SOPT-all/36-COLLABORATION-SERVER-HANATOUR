package sopt.hana.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.hana.tour.domain.Condition;

@Repository
public interface ConditionRepository extends JpaRepository<Condition,Long> {
}
