package sopt.hana.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.hana.tour.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
}
