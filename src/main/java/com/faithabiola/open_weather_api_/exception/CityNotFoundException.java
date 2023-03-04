package com.faithabiola.open_weather_api_.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String error) {
        super(error);
    }

}
