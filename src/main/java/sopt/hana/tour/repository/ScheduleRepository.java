package sopt.hana.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.hana.tour.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
