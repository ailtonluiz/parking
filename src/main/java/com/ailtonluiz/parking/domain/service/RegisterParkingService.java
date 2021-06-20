package com.ailtonluiz.parking.domain.service;

import com.ailtonluiz.parking.domain.exception.EntityInUseException;
import com.ailtonluiz.parking.domain.exception.EntityNotFoundException;
import com.ailtonluiz.parking.domain.model.Parking;
import com.ailtonluiz.parking.domain.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RegisterParkingService {

    private static final String MESSAGE_IN_USE
            = "Parkinge de código %d não pode ser removida, pois está em uso";

    private static final String MESSAGE_NOT_FOUND
            = "Não existe um cadastro de parkinge com código %d";


    @Autowired
    private ParkingRepository parkingRepository;

    public Parking save(Parking parking) {
        return parkingRepository.save(parking);
    }

    public void delete(Long parkingId) {
        try {
            parkingRepository.deleteById(parkingId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format(MESSAGE_NOT_FOUND, parkingId));

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MESSAGE_IN_USE, parkingId));
        }
    }

    public Parking searchOrFail(Long parkingId) {
        return parkingRepository.findById(parkingId).orElseThrow(() -> new EntityNotFoundException(
                String.format(MESSAGE_NOT_FOUND, parkingId)
        ));
    }
}
