package sopt.hana.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.hana.tour.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
}
