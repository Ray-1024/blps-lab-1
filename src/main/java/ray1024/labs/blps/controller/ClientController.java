package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ClientController {
    @PostMapping("/api/users/{userId}/client/orders")
    void createOrder() {

    }

    @GetMapping("/api/users/{userId}/client/orders")
    void getOrders() {

    }
}
