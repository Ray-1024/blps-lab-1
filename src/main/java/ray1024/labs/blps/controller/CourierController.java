package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CourierController {

    @GetMapping("/api/users/{userId}/courier/orders")
    void getOrders() {

    }


}
