package com.ailtonluiz.parking.domain.service;

import com.ailtonluiz.parking.domain.exception.EntityInUseException;
import com.ailtonluiz.parking.domain.exception.EntityNotFoundException;
import com.ailtonluiz.parking.domain.model.City;
import com.ailtonluiz.parking.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RegisterCityService {

    private static final String MESSAGE_CITY_IN_USE
            = "Cidade de código %d não pode ser removida, pois está em uso";

    private static final String MESSAGE_CITY_NOT_FOUND
            = "Não existe um cadastro de cidade com código %d";

    @Autowired
    private CityRepository cityRepository;

    public City save(City city) {


        return cityRepository.save(city);
    }

    public void delete(Long cityId) {
        try {
            cityRepository.deleteById(cityId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format("Não existe um cadastro de Cidade com código %d", cityId));

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", cityId));
        }
    }

    public City searchOrFail(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(MESSAGE_CITY_NOT_FOUND, cityId)));

    }
}
