package weather.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "Weather")
@Getter
@Setter
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "temperature")
    private Double temp;

    @Column(name = "wind_mph")
    private Double windMph;

    @Column(name = "pressure_mb")
    private Double pressureMb;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "location")
    private LocationEntity location;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "condition")
    private ConditionEntity condition;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @Column(name = "humidity")
    private Integer humidity;
}
