package weather.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WeatherDTO {

    private Double tempC;
    private Double windMph;
    private Double pressureMb;
    private ConditionDTO condition;
    private Integer humidity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime lastUpdated;
}
