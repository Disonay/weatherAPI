package weather.api.dto;

import lombok.Data;

@Data
public class ExternalApiResponseDTO {
    WeatherDTO current;
    LocationDTO location;
}
