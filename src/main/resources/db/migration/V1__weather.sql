CREATE TABLE Location (
    id SERIAL PRIMARY KEY NOT NULL,
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL
);

CREATE TABLE Condition (
    id SERIAL PRIMARY KEY NOT NULL,
    condition VARCHAR(255) NOT NULL
);

CREATE TABLE Weather (
    id SERIAL PRIMARY KEY NOT NULL,
    temperature DOUBLE PRECISION NOT NULL,
    wind_mph DOUBLE PRECISION NOT NULL,
    pressure_mb DOUBLE PRECISION NOT NULL,
    humidity INTEGER NOT NULL,
    location BIGINT REFERENCES Location (id),
    condition BIGINT REFERENCES Condition (id),
    last_updated TIMESTAMP NOT NULL
);