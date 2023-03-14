package com.faithabiola.open_weather_api_.exception;

import lombok.Data;

@Data
public class CityNotFoundException extends RuntimeException {

    private final Integer cod;

    public CityNotFoundException(String error, Integer cod) {
        super(error);
        this.cod = cod;
    }

}
