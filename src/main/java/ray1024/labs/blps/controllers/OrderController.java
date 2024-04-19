package ray1024.labs.blps.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ray1024.labs.blps.model.Order;
import ray1024.labs.blps.model.responce.UserOrdersResponce;

import java.util.List;

@RestController
public class OrderController {

    @GetMapping("/api/users/{userId}/orders")
    UserOrdersResponce getOrders(@PathVariable String userId) {
        return new UserOrdersResponce(List.of(new Order("id",null)));
    }

}
