package ray1024.labs.blps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.exception.ClientNotFoundException;
import ray1024.labs.blps.model.entity.Client;
import ray1024.labs.blps.repository.ClientRepository;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public Client getByUserId(Long userId) {
        Optional<Client> clientO = clientRepository.findByUserId(userId);
        if (clientO.isEmpty()) throw new ClientNotFoundException();
        return clientO.get();
    }
}
