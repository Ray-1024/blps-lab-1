package ray1024.labs.blps.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ray1024.labs.blps.services.CourierService;

@AllArgsConstructor
@RestController("/api/couriers")
public class CourierController {
    private final CourierService courierService;

}
