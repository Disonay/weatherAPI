package weather.api.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import weather.api.dto.AvgWeatherDTO;
import weather.api.dto.ResponseDTO;
import weather.api.dto.TimeDTO;
import weather.api.entity.WeatherEntity;
import weather.api.mapper.WeatherMapper;
import weather.api.repository.weather.WeatherRepository;

@Component
@RequiredArgsConstructor
public class WeatherDataProvider {
    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    public ResponseDTO getCurrentWeatherData() {
        WeatherEntity weatherEntity = weatherRepository.findTopByOrderByLastUpdatedDesc();

        return  weatherMapper.weatherToResponseDto(weatherEntity);
    }

    public AvgWeatherDTO getAvgWeatherInfoByPeriod(TimeDTO timeDTO) {
        return weatherRepository.getAvgWeatherInfoByPeriod(timeDTO.getFrom(), timeDTO.getTo());
    }
}
