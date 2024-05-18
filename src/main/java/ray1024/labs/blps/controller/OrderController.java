package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.Order;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.OrderRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class OrderController {
    private final OrderRepository orderRepository;

    @PostMapping("/api/orders")
    public ResultResponse create(@RequestBody Order order) {
        return new SuccessResult<>(orderRepository.save(order));
    }

    @GetMapping("/api/orders/{orderId}")
    public ResultResponse get(@PathVariable Long orderId) {
        Optional<Order> userO = orderRepository.findById(orderId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/orders/{orderId}")
    public ResultResponse modify(@RequestBody Order order, @PathVariable Long orderId) {
        Optional<Order> userO = orderRepository.findById(orderId);
        if (userO.isEmpty()) return new FailureResult("Order doesn't exist");
        return new SuccessResult<>(orderRepository.save(order));
    }

    @DeleteMapping("/api/orders/{orderId}")
    public ResultResponse delete(@PathVariable Long orderId) {
        Optional<Order> userO = orderRepository.findById(orderId);
        if (userO.isEmpty()) return new FailureResult("Order doesn't exist");
        return new SuccessResult<>(userO.get());
    }

}
