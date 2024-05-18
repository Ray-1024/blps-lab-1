package ray1024.labs.blps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.exception.ShopDoesntExistsException;
import ray1024.labs.blps.model.entity.Shop;
import ray1024.labs.blps.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public List<Long> getAllIds() {
        return shopRepository.findAll().stream().map(Shop::getId).toList();
    }

    public Shop getById(Long shopId) throws ShopDoesntExistsException {
        Optional<Shop> shop = shopRepository.findById(shopId);
        if (shop.isEmpty()) throw new ShopDoesntExistsException();
        return shop.get();
    }

    public boolean containsAllItems(Long shopId, List<Long> itemIds) {
        Shop shop = getById(shopId);
        return itemIds.stream().allMatch(itemId -> shop.getItems().contains(itemId));
    }

    public Shop create(Shop shop) {
        return shopRepository.save(shop);
    }
}
