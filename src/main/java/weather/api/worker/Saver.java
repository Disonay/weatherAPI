package weather.api.worker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import weather.api.dto.ExternalApiResponseDTO;
import weather.api.mapper.WeatherMapper;
import weather.api.repository.weather.WeatherRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Saver implements Worker {
    private Optional<ExternalApiResponseDTO> data;
    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    public Worker payload(Optional<ExternalApiResponseDTO> data) {
        this.data = data;

        return this;
    }

    @Override
    public void execute() {
        data.ifPresent(dto -> weatherRepository.saveIfExists(weatherMapper.infoDtoToWeather(dto)));
    }
}
