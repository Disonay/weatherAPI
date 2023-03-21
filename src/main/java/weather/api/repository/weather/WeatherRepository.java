package weather.api.repository.weather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weather.api.entity.WeatherEntity;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long>, CustomWeatherRepository {
    WeatherEntity findTopByOrderByLastUpdatedDesc();

}


