package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.Order;
import ray1024.labs.blps.model.entity.Packer;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.OrderRepository;
import ray1024.labs.blps.repository.PackerRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class PackerController {
    private final PackerRepository packerRepository;
    private final OrderRepository orderRepository;

    @PostMapping("/api/users/{userId}/packer")
    public ResultResponse create(@RequestBody Packer packer, @PathVariable Long userId) {
        Optional<Packer> packerO = packerRepository.findByUserId(userId);
        if (packerO.isPresent()) return new FailureResult("Packer already exists");
        return new SuccessResult<>(packerRepository.save(packer));
    }

    @GetMapping("/api/users/{userId}/packer")
    public ResultResponse get(@PathVariable Long userId) {
        Optional<Packer> userO = packerRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/users/{userId}/packer")
    public ResultResponse modify(@RequestBody Packer packer, @PathVariable Long userId) {
        Optional<Packer> userO = packerRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("Packer doesn't exist");
        return new SuccessResult<>(packerRepository.save(packer));
    }

    @DeleteMapping("/api/users/{userId}/packer")
    public ResultResponse delete(@PathVariable Long userId) {
        Optional<Packer> userO = packerRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("Packer doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/users/{userId}/packer/orders/{orderId}")
    public ResultResponse setPacked(@PathVariable Long userId, @PathVariable Long orderId) {
        Optional<Packer> packerO = packerRepository.findByUserId(userId);
        if (packerO.isEmpty()) return new FailureResult("Packer doesn't exist");
        Optional<Order> orderO = orderRepository.findById(orderId);
        if (orderO.isEmpty()) return new FailureResult("Order doesn't exist");
        orderO.get().setStatus(Order.Status.PACKED);
        return new SuccessResult<>(orderRepository.save(orderO.get()));
    }

    @GetMapping("/api/users/{userId}/packer/orders")
    public ResultResponse getOrders(@PathVariable Long userId) {
        Optional<Packer> packerO = packerRepository.findByUserId(userId);
        if (packerO.isEmpty()) return new FailureResult("Packer doesn't exist");
        return new SuccessResult<>(orderRepository.findAllByPackerId(userId));
    }

    @PostMapping("/api/users/{userId}/packer/orders")
    public ResultResponse findNewOrder(@PathVariable Long userId) {
        Optional<Packer> packerO = packerRepository.findByUserId(userId);
        if (packerO.isEmpty()) return new FailureResult("Packer doesn't exist");
        Optional<Order> orderO = orderRepository.findAnyByShopIdAndPackerIsNull(packerO.get().getShop().getId());
        if (orderO.isEmpty()) return new FailureResult("Nothing to do");
        orderO.get().setPacker(packerO.get());
        return new SuccessResult<>(orderRepository.save(orderO.get()));
    }

}
