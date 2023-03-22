package weather.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import weather.api.dto.*;
import weather.api.service.WeatherService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WeatherControllerTest {
    @MockBean
    private WeatherService weatherService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getActualWeather() throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();

        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setTempC(20.0);
        weatherDTO.setWindMph(5.0);
        weatherDTO.setPressureMb(1000.0);

        ConditionDTO conditionDTO = new ConditionDTO();
        conditionDTO.setCondition("Cloudy");

        weatherDTO.setCondition(conditionDTO);
        weatherDTO.setHumidity(50);
        weatherDTO.setLastUpdated(LocalDateTime.now());

        responseDTO.setWeather(weatherDTO);

        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setCity("Minsk");
        locationDTO.setCountry("Belarus");

        responseDTO.setLocation(locationDTO);

        when(weatherService.getActualWeather()).thenReturn(responseDTO);

        mockMvc.perform(get("/weather/api/current"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(responseDTO)));

    }

    @Test
    void testGetAverageWeather() throws Exception {
        TimeDTO timeDTO = new TimeDTO();
        timeDTO.setFrom(LocalDate.parse("2022-03-21"));
        timeDTO.setTo(LocalDate.parse("2022-03-23"));

        AvgWeatherDTO expectedResponse = new AvgWeatherDTO();
        expectedResponse.setAvgTemp(8.0);
        expectedResponse.setAvgHumidity(61.0);
        expectedResponse.setAvgPressureMb(1015.0);
        expectedResponse.setAvgWindMph(9.4);

        when(weatherService.getAverageWeather(any(TimeDTO.class))).thenReturn(expectedResponse);

        mockMvc.perform(post("/weather/api/avg")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(timeDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }
}