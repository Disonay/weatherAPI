package weather.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weather.api.dto.AvgWeatherDTO;
import weather.api.dto.ResponseDTO;
import weather.api.dto.TimeDTO;
import weather.api.provider.WeatherDataProvider;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherDataProvider weatherDataProvider;

    public ResponseDTO getActualWeather() {

        return weatherDataProvider.getCurrentWeatherData();
    }

    public AvgWeatherDTO getAverageWeather(TimeDTO timePeriod) {

        return weatherDataProvider.getAvgWeatherInfoByPeriod(timePeriod);
    }
}
