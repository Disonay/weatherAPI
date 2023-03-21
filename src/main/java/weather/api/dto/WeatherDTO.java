package weather.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WeatherDTO {
    @JsonProperty("temp_c")
    Double temp;

    @JsonProperty("wind_mph")
    Double windMph;

    @JsonProperty("pressure_mb")
    Double pressureMb;

    ConditionDTO condition;

    Integer humidity;

    @JsonProperty("last_updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime lastUpdated;
}
