package ray1024.labs.blps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.repository.ItemRepository;

@AllArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

}