package sopt.hana.tour.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name ="schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;

	@OneToOne
	@JoinColumn(name = "package_id",nullable = false)
	private Package pkg;

	private LocalDateTime departDate;
	private LocalDateTime arriveDate;
	private String departure;
	private String arrival;

	public Schedule (){

	}

	public Schedule(Package pkg, LocalDateTime departDate, LocalDateTime arriveDate, String arrival, String departure) {
		this.pkg = pkg;
		this.departDate = departDate;
		this.arriveDate = arriveDate;
		this.arrival = arrival;
		this.departure = departure;
	}
}
