package weather.api.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import weather.api.dto.ExternalApiResponseDTO;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ApiDataProvider {

    private final WebClient webClient;

    public Optional<ExternalApiResponseDTO> getCurrentWeatherFromApi() {
        return Optional.ofNullable(
                webClient
                        .get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/current.json")
                                .queryParam("key", "4ecdfc7ef90547e3b47184503231803")
                                .queryParam("q", "Minsk")
                                .build()
                        )
                        .retrieve()
                        .bodyToMono(ExternalApiResponseDTO.class).block()
        );
    }
}
