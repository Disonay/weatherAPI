package weather.api.dto;

import lombok.Data;

@Data
public class ExternalApiResponseDTO {
    private WeatherDTO current;
    private LocationDTO location;
}
