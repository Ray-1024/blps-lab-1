package ray1024.labs.blps.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.repository.ShopRepository;

@Service
@AllArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
}
