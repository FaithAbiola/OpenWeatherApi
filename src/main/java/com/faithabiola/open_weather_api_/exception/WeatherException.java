package com.faithabiola.open_weather_api_.exception;
public class WeatherException extends RuntimeException {

    public WeatherException(String error) {
        super(error);
    }

}
