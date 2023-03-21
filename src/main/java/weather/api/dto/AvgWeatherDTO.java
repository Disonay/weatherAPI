package weather.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvgWeatherDTO {
    @JsonProperty(value = "avg_temp")
    Double avgTemperature;

    @JsonProperty(value = "avg_wind_mph")
    Double avgWindMph;

    @JsonProperty(value = "avg_pressure_mph")
    Double avgPressureMb;

    @JsonProperty(value = "avg_humidity")
    Double avgHumidity;
}
