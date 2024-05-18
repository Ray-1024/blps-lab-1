package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.Client;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.ClientRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class ClientController {
    private final ClientRepository clientRepository;

    @PostMapping("/api/clients")
    public ResultResponse create(@RequestBody Client client) {
        Optional<Client> clientO = clientRepository.findByUserId(client.getUser().getId());
        if (clientO.isPresent()) return new FailureResult("Client already exists");
        return new SuccessResult<>(clientRepository.save(client));
    }

    @GetMapping("/api/clients/{clientId}")
    public ResultResponse get(@PathVariable Long clientId) {
        Optional<Client> userO = clientRepository.findById(clientId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/clients/{clientId}")
    public ResultResponse modify(@RequestBody Client client, @PathVariable Long clientId) {
        Optional<Client> userO = clientRepository.findById(clientId);
        if (userO.isEmpty()) return new FailureResult("Client doesn't exist");
        return new SuccessResult<>(clientRepository.save(client));
    }

    @DeleteMapping("/api/clients/{clientId}")
    public ResultResponse delete(@PathVariable Long clientId) {
        Optional<Client> userO = clientRepository.findById(clientId);
        if (userO.isEmpty()) return new FailureResult("Client doesn't exist");
        return new SuccessResult<>(userO.get());
    }
}
