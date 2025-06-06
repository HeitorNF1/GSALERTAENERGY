package com.globalsolution.alertenergy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "energyApi", url = "https://api.open-meteo.com/v1")
public interface EnergyApiClient {

    @GetMapping("/forecast")
    String getWeatherForecast(@RequestParam("latitude") double lat,
                              @RequestParam("longitude") double lon,
                              @RequestParam("hourly") String hourly);
}
