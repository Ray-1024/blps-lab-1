package ray1024.labs.blps.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.repository.ItemRepository;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
}
