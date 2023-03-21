package weather.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import weather.api.dto.AvgWeatherDTO;
import weather.api.dto.ResponseDTO;
import weather.api.dto.TimeDTO;
import weather.api.service.WeatherService;

@RestController
@RequestMapping("/weather/api")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getActualWeather() {

        ResponseDTO responseDTO = weatherService.getActualWeather();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDTO);
    }

    @PostMapping(value = "/avg", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvgWeatherDTO> getAverageWeather(@RequestBody @Validated TimeDTO timeDTO) {

        AvgWeatherDTO avgWeatherDTO = weatherService.getAverageWeather(timeDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(avgWeatherDTO);
    }
}
