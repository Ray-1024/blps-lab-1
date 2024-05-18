package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.Shop;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.ShopRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class ShopController {
    private final ShopRepository shopRepository;

    @GetMapping("/api/shops")
    public ResultResponse getShops() {
        return new SuccessResult<>(shopRepository.findAll().stream().map(Shop::getShop_id).toList());
    }

    @PostMapping("/api/shops")
    public ResultResponse create(@RequestBody Shop shop) {
        Optional<Shop> shopO = shopRepository.findByAddress(shop.getAddress());
        if (shopO.isPresent()) return new FailureResult("Shop already exists");
        return new SuccessResult<>(shopRepository.save(shop));
    }

    @GetMapping("/api/shops/{shopId}")
    public ResultResponse get(@PathVariable Long shopId) {
        Optional<Shop> userO = shopRepository.findById(shopId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/shops/{shopId}")
    public ResultResponse modify(@RequestBody Shop shop, @PathVariable Long shopId) {
        Optional<Shop> userO = shopRepository.findById(shopId);
        if (userO.isEmpty()) return new FailureResult("Shop doesn't exist");
        return new SuccessResult<>(shopRepository.save(shop));
    }

    @DeleteMapping("/api/shops/{shopId}")
    public ResultResponse delete(@PathVariable Long shopId) {
        Optional<Shop> userO = shopRepository.findById(shopId);
        if (userO.isEmpty()) return new FailureResult("Shop doesn't exist");
        return new SuccessResult<>(userO.get());
    }
}
