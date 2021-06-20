package com.ailtonluiz.parking.domain.service;

import com.ailtonluiz.parking.domain.exception.EntityInUseException;
import com.ailtonluiz.parking.domain.exception.EntityNotFoundException;
import com.ailtonluiz.parking.domain.model.Company;
import com.ailtonluiz.parking.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RegisterCompanyService {

    private static final String MESSAGE_IN_USE
            = "Companye de código %d não pode ser removida, pois está em uso";

    private static final String MESSAGE_NOT_FOUND
            = "Não existe um cadastro de companye com código %d";


    @Autowired
    private CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public void delete(Long companyId) {
        try {
            companyRepository.deleteById(companyId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format(MESSAGE_NOT_FOUND, companyId));

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MESSAGE_IN_USE, companyId));
        }
    }

    public Company searchOrFail(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new EntityNotFoundException(
                String.format(MESSAGE_NOT_FOUND, companyId)
        ));
    }
}
