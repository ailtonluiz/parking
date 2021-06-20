package com.ailtonluiz.parking.domain.service;

import com.ailtonluiz.parking.domain.exception.EntityInUseException;
import com.ailtonluiz.parking.domain.exception.EntityNotFoundException;
import com.ailtonluiz.parking.domain.model.Client;
import com.ailtonluiz.parking.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RegisterClientService {

    private static final String MESSAGE_IN_USE
            = "Cliente de código %d não pode ser removida, pois está em uso";

    private static final String MESSAGE_NOT_FOUND
            = "Não existe um cadastro de cliente com código %d";


    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long clientId) {
        try {
            clientRepository.deleteById(clientId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format(MESSAGE_NOT_FOUND, clientId));

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MESSAGE_IN_USE, clientId));
        }
    }

    public Client searchOrFail(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException(
                String.format(MESSAGE_NOT_FOUND, clientId)
        ));
    }
}
