package weather.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConditionDTO {
    @JsonProperty("text")
    private String condition;
}
