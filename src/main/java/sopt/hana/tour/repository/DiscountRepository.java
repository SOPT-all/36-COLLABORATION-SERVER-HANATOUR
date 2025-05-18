package sopt.hana.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.hana.tour.domain.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
