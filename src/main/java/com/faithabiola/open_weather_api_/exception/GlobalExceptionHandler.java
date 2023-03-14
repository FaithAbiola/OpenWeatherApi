package com.faithabiola.open_weather_api_.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<String> cityNotFound(CityNotFoundException cityNotFoundException) {
        return new ResponseEntity<>(cityNotFoundException.getMessage(), HttpStatus.valueOf(cityNotFoundException.getCod()));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> cityNotFound(HttpClientErrorException httpClientErrorException) {
        return new ResponseEntity<>(httpClientErrorException.getMessage(), HttpStatus.valueOf(404));
    }
}
