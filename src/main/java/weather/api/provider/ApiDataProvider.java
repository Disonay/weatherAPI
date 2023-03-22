package weather.api.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import weather.api.dto.ExternalApiResponseDTO;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ApiDataProvider {

    private final WebClient webClient;

    @Value("${values.api.key}")
    private String key;

    @Value("${values.api.q}")
    private String q;

    public Optional<ExternalApiResponseDTO> getCurrentWeatherFromApi() {
        return Optional.ofNullable(
                webClient
                        .get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/current.json")
                                .queryParam("key", key)
                                .queryParam("q", q)
                                .build()
                        )
                        .retrieve()
                        .bodyToMono(ExternalApiResponseDTO.class).block()
        );
    }
}
