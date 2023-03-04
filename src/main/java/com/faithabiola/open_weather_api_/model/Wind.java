package com.faithabiola.open_weather_api_.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind {
    private Double speed;
    private Integer deg;
    private Double gust;
}
