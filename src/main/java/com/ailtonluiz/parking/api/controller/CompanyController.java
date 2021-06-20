package com.ailtonluiz.parking.api.controller;

import com.ailtonluiz.parking.domain.model.Company;
import com.ailtonluiz.parking.domain.repository.CompanyRepository;
import com.ailtonluiz.parking.domain.service.RegisterCompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RegisterCompanyService registerCompanyService;

    @GetMapping
    public List<Company> list() {
        return companyRepository.findAll();
    }

    @GetMapping("/{companyId}")
    public Company search(@PathVariable Long companyId) {
        return registerCompanyService.searchOrFail(companyId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company add(@RequestBody Company company) {
        return company = registerCompanyService.save(company);
    }

    @PutMapping("/{companyId}")
    public Company update(@PathVariable Long companyId,
                       @RequestBody Company company) {
        Company currentCompany = registerCompanyService.searchOrFail(companyId);

        BeanUtils.copyProperties(company, currentCompany, "id");
        return registerCompanyService.save(currentCompany);
    }

    @DeleteMapping("/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long companyId) {
        registerCompanyService.delete(companyId);
    }
}
