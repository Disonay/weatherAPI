package weather.api.scheduled;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import weather.api.dto.ExternalApiResponseDTO;
import weather.api.provider.ApiDataProvider;
import weather.api.worker.Saver;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataScheduler {
    private final ApiDataProvider apiDataProvider;
    private final Saver saver;

    @Scheduled(fixedDelayString = "${values.delay}")
    void ScheduledWeatherTask() {
        Optional<ExternalApiResponseDTO> infoDTO = apiDataProvider.getCurrentWeatherFromApi();
        saver.payload(infoDTO).execute();
    }
}
