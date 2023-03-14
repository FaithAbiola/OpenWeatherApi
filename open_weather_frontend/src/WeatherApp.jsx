import React, { useState } from "react";
import axios from "axios";
import "./WeatherApp.css";

function WeatherApp() {
    const [city, setCity] = useState("");
    const [weather, setWeather] = useState("");
    const [error, setError] = useState("");

    const parser = new DOMParser();

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.get(
                `http://localhost:8080/city/${city}`
            );
            const xmlDoc = parser.parseFromString(response.data, "text/xml");
            const weatherElement = xmlDoc.getElementsByTagName("weather")[0];
            let description =
                weatherElement.getElementsByTagName("description")[0].textContent;
            description = description.charAt(0).toUpperCase() + description.slice(1);
            setWeather(description);
            setError("");
        } catch (error) {
            setWeather("");
            setError(error.response.data.message);
        }
    };

    const handleInputChange = (event) => { // what will make the endpoint run when clicked
        setCity(event.target.value);
        setWeather("");
    };

    return (
        <div className="container">
            <h1>Weather App</h1>
            <form onSubmit={handleSubmit}>
                <label htmlFor="city">Enter City Name:</label>
                <input
                    type="text"
                    id="city"
                    name="city"
                    value={city}
                    onChange={handleInputChange}
                />
                <button type="submit">Find</button>
            </form>
            <div>
                <h1 className="weather-description">Weather Description</h1>
                <p>
                    {error ? (
                        <div className="error">{error}</div>
                    ) : (
                        <div className="weather"><h2>{weather}</h2></div>
                    )}
                </p>
            </div>
        </div>
    );
}

export default WeatherApp;
