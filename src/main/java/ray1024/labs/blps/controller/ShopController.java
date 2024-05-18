package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ray1024.labs.blps.model.responce.ShopResponse;
import ray1024.labs.blps.model.responce.ShopsResponse;
import ray1024.labs.blps.service.ShopService;

@AllArgsConstructor
@RestController
public class ShopController {
    private final ShopService shopService;

    @GetMapping("/api/shops")
    public ShopsResponse getShops() {
        return new ShopsResponse(shopService.getAllIds());
    }

    @GetMapping("/api/shops/{shopId}")
    public ShopResponse getShop(@PathVariable Long shopId) {
        return new ShopResponse(shopService.getById(shopId));
    }
}
