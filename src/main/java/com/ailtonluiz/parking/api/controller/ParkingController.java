package com.ailtonluiz.parking.api.controller;

import com.ailtonluiz.parking.domain.model.Parking;
import com.ailtonluiz.parking.domain.repository.ParkingRepository;
import com.ailtonluiz.parking.domain.service.RegisterParkingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parkings")
public class ParkingController {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private RegisterParkingService registerParkingService;

    @GetMapping
    public List<Parking> list() {
        return parkingRepository.findAll();
    }

    @GetMapping("/{parkingId}")
    public Parking search(@PathVariable Long parkingId) {
        return registerParkingService.searchOrFail(parkingId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parking add(@RequestBody Parking parking) {
        return parking = registerParkingService.save(parking);
    }

    @PutMapping("/{parkingId}")
    public Parking update(@PathVariable Long parkingId,
                       @RequestBody Parking parking) {
        Parking currentParking = registerParkingService.searchOrFail(parkingId);

        BeanUtils.copyProperties(parking, currentParking, "id");
        return registerParkingService.save(currentParking);
    }

    @DeleteMapping("/{parkingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long parkingId) {
        registerParkingService.delete(parkingId);
    }
}
