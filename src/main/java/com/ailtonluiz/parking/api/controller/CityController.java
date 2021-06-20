package com.ailtonluiz.parking.api.controller;

import com.ailtonluiz.parking.domain.model.City;
import com.ailtonluiz.parking.domain.repository.CityRepository;
import com.ailtonluiz.parking.domain.service.RegisterCityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RegisterCityService registerCityService;

    @GetMapping
    public List<City> list() {
        return cityRepository.findAll();
    }

    @GetMapping("/{cityId}")
    public City search(@PathVariable Long cityId) {
        return registerCityService.searchOrFail(cityId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City add(@RequestBody City city) {
        return city = registerCityService.save(city);
    }

    @PutMapping("/{cityId}")
    public City update(@PathVariable Long cityId,
                       @RequestBody City city) {
        City currentCity = registerCityService.searchOrFail(cityId);

        BeanUtils.copyProperties(city, currentCity, "id");
        return registerCityService.save(currentCity);
    }

    @DeleteMapping("/{cityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long cityId) {
        registerCityService.delete(cityId);
    }
}
