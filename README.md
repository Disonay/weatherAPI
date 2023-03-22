# weatherAPI

The Weather API is an application that fetches weather data from a third-party API and stores it in a database at 
specified intervals for a particular city. 

## API endpoints
1. `/api/weather/current`

This endpoint returns the current weather information.

Response example:
```json
{
    "temp_c": 8.0,
    "wind_mph": 9.4,
    "pressure_mb": 1015.0,
    "condition": {
        "text": "Partly cloudy"
    },
    "humidity": 61,
    "last_updated": "2023-03-22 15:30",
    "location": {
        "city": "Minsk",
        "country": "Belarus"
    }
}
```

2. `/api/weather/avg`

This endpoint returns the average daily temperature over a given period.

Request example:
```json
{
    "from": "2023-03-20",
    "to": "2023-02-23"
}
```

Response example
```json
{
  "avg_temp": 7.2,
  "avg_wind_mph": 11.06,
  "avg_pressure_mb": 1012.54,
  "avg_humidity": 77.06
}
```
