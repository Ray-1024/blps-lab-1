package ray1024.labs.blps.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ray1024.labs.blps.model.responce.UserOrdersResponce;
import ray1024.labs.blps.services.OrderService;

import java.util.List;

@AllArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/api/users/{userId}/orders")
    UserOrdersResponce getOrders(@PathVariable String userId) {
        return new UserOrdersResponce(null, List.of());
    }

}
