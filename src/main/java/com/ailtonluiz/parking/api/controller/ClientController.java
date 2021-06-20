package com.ailtonluiz.parking.api.controller;

import com.ailtonluiz.parking.domain.model.Client;
import com.ailtonluiz.parking.domain.repository.ClientRepository;
import com.ailtonluiz.parking.domain.service.RegisterClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RegisterClientService registerClientService;

    @GetMapping
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public Client search(@PathVariable Long clientId) {
        return registerClientService.searchOrFail(clientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@RequestBody Client client) {
        return client = registerClientService.save(client);
    }

    @PutMapping("/{clientId}")
    public Client update(@PathVariable Long clientId,
                       @RequestBody Client client) {
        Client currentClient = registerClientService.searchOrFail(clientId);

        BeanUtils.copyProperties(client, currentClient, "id");
        return registerClientService.save(currentClient);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long clientId) {
        registerClientService.delete(clientId);
    }
}
