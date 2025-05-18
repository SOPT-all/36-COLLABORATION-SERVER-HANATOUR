package sopt.hana.tour.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "package_id", nullable = false, unique = true)
    private Package pkg;

    @Column(name = "depart_date", nullable = false)
    private LocalDateTime departDate;

    @Column(name = "arrive_date", nullable = false)
    private LocalDateTime arriveDate;

    @Column(name = "departure", nullable = false)
    private String departure;

    @Column(name = "arrival", nullable = false)
    private String arrival;

    @Builder
    public Schedule(Package pkg, LocalDateTime departDate, LocalDateTime arriveDate,
                    String departure, String arrival) {
        this.pkg = pkg;
        this.departDate = departDate;
        this.arriveDate = arriveDate;
        this.departure = departure;
        this.arrival = arrival;
    }
}
