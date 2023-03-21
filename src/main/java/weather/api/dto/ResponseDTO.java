package weather.api.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

@Data
public class ResponseDTO
{
    @JsonUnwrapped
    WeatherDTO weather;

    LocationDTO location;
}
