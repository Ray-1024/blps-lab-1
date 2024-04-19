package ray1024.labs.blps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.repository.ShopRepository;

@Service
@AllArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
}
