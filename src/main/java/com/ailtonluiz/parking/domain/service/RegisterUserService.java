package com.ailtonluiz.parking.domain.service;

import com.ailtonluiz.parking.domain.exception.EntityInUseException;
import com.ailtonluiz.parking.domain.exception.EntityNotFoundException;
import com.ailtonluiz.parking.domain.model.User;
import com.ailtonluiz.parking.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private static final String MESSAGE_IN_USE
            = "Usere de código %d não pode ser removida, pois está em uso";

    private static final String MESSAGE_NOT_FOUND
            = "Não existe um cadastro de usere com código %d";


    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format(MESSAGE_NOT_FOUND, userId));

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MESSAGE_IN_USE, userId));
        }
    }

    public User searchOrFail(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(
                String.format(MESSAGE_NOT_FOUND, userId)
        ));
    }
}
