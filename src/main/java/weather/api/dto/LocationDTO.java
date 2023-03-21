package weather.api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class LocationDTO {
    @JsonAlias("region")
    String city;
    String country;
}
