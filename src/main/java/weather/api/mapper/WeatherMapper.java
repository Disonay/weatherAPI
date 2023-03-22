package weather.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import weather.api.dto.ExternalApiResponseDTO;
import weather.api.dto.ResponseDTO;
import weather.api.entity.WeatherEntity;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    @Mapping(source = "tempC", target = "weather.tempC")
    @Mapping(source = "windMph", target = "weather.windMph")
    @Mapping(source = "pressureMb", target = "weather.pressureMb")
    @Mapping(source = "condition", target = "weather.condition")
    @Mapping(source = "lastUpdated", target = "weather.lastUpdated")
    @Mapping(source = "humidity", target = "weather.humidity")
    ResponseDTO weatherToResponseDto(WeatherEntity weatherEntity);
    @Mapping(source = "current.tempC", target = "tempC")
    @Mapping(source = "current.windMph", target = "windMph")
    @Mapping(source = "current.pressureMb", target = "pressureMb")
    @Mapping(source = "current.condition", target = "condition")
    @Mapping(source = "current.lastUpdated", target = "lastUpdated")
    @Mapping(source = "current.humidity", target = "humidity")
    WeatherEntity infoDtoToWeather(ExternalApiResponseDTO externalApiResponseDTO);
}
