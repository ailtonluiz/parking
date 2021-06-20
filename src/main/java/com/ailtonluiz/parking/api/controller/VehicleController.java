package com.ailtonluiz.parking.api.controller;

import com.ailtonluiz.parking.domain.model.Vehicle;
import com.ailtonluiz.parking.domain.repository.VehicleRepository;
import com.ailtonluiz.parking.domain.service.RegisterVehicleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RegisterVehicleService registerVehicleService;

    @GetMapping
    public List<Vehicle> list() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/{vehicleId}")
    public Vehicle search(@PathVariable Long vehicleId) {
        return registerVehicleService.searchOrFail(vehicleId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle add(@RequestBody Vehicle vehicle) {
        return vehicle = registerVehicleService.save(vehicle);
    }

    @PutMapping("/{vehicleId}")
    public Vehicle update(@PathVariable Long vehicleId,
                       @RequestBody Vehicle vehicle) {
        Vehicle currentVehicle = registerVehicleService.searchOrFail(vehicleId);

        BeanUtils.copyProperties(vehicle, currentVehicle, "id");
        return registerVehicleService.save(currentVehicle);
    }

    @DeleteMapping("/{vehicleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long vehicleId) {
        registerVehicleService.delete(vehicleId);
    }
}
