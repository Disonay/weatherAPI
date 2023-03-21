package weather.api.repository.weather;

import weather.api.dto.AvgWeatherDTO;
import weather.api.entity.WeatherEntity;

import java.time.LocalDate;

public interface CustomWeatherRepository {
    void saveIfExists(WeatherEntity weatherEntity);
    AvgWeatherDTO getAvgWeatherInfoByPeriod(LocalDate from, LocalDate to);
}
