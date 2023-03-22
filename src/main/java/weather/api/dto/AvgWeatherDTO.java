package weather.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvgWeatherDTO {

    private Double avgTemp;

    private Double avgWindMph;

    private Double avgPressureMb;

    private Double avgHumidity;
}
