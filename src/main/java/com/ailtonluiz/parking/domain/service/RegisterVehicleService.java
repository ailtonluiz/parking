package com.ailtonluiz.parking.domain.service;

import com.ailtonluiz.parking.domain.exception.EntityInUseException;
import com.ailtonluiz.parking.domain.exception.EntityNotFoundException;
import com.ailtonluiz.parking.domain.model.Vehicle;
import com.ailtonluiz.parking.domain.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RegisterVehicleService {

    private static final String MESSAGE_VEHICLE_IN_USE
            = "Cidade de código %d não pode ser removida, pois está em uso";

    private static final String MESSAGE_VEHICLE_NOT_FOUND
            = "Não existe um cadastro de cidade com código %d";

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {


        return vehicleRepository.save(vehicle);
    }

    public void delete(Long vehicleId) {
        try {
            vehicleRepository.deleteById(vehicleId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format("Não existe um cadastro de Cidade com código %d", vehicleId));

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", vehicleId));
        }
    }

    public Vehicle searchOrFail(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(MESSAGE_VEHICLE_NOT_FOUND, vehicleId)));

    }
}
