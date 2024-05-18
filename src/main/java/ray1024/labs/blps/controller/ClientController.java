package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.Client;
import ray1024.labs.blps.model.entity.Order;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.ClientRepository;
import ray1024.labs.blps.repository.OrderRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class ClientController {
    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;

    @PostMapping("/api/users/{userId}/client")
    public ResultResponse create(@RequestBody Client client, @PathVariable Long userId) {
        Optional<Client> clientO = clientRepository.findByUserId(userId);
        if (clientO.isPresent()) return new FailureResult("Client already exists");
        return new SuccessResult<>(clientRepository.save(client));
    }

    @GetMapping("/api/users/{userId}/client")
    public ResultResponse get(@PathVariable Long userId) {
        Optional<Client> userO = clientRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/users/{userId}/client")
    public ResultResponse modify(@RequestBody Client client, @PathVariable Long userId) {
        Optional<Client> userO = clientRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("Client doesn't exist");
        return new SuccessResult<>(clientRepository.save(client));
    }

    @DeleteMapping("/api/users/{userId}/client")
    public ResultResponse delete(@PathVariable Long userId) {
        Optional<Client> userO = clientRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("Client doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PostMapping("/api/users/{userId}/client/orders")
    public ResultResponse order(@PathVariable Long userId, @RequestBody Order order) {
        Optional<Client> clientO = clientRepository.findByUserId(userId);
        if (clientO.isEmpty()) return new FailureResult("Client doesn't exist");
        if (!order.getClient().equals(clientO.get())) return new FailureResult("Bad order");
        order.setStatus(Order.Status.ORDERED);
        return new SuccessResult<>(orderRepository.save(order));
    }

    @GetMapping("/api/users/{userId}/client/orders")
    public ResultResponse orders(@PathVariable Long userId) {
        Optional<Client> clientO = clientRepository.findByUserId(userId);
        if (clientO.isEmpty()) return new FailureResult("Client doesn't exist");
        return new SuccessResult<>(orderRepository.findAllByClientId(userId));
    }
}
