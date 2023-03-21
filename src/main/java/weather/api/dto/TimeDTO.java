package weather.api.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
public class TimeDTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate from;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate to;
}
