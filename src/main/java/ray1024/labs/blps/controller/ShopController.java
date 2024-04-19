package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ray1024.labs.blps.service.ShopService;

@AllArgsConstructor
@RestController("/api/shops")
public class ShopController {
    private final ShopService shopService;

}
