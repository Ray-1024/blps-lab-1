package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.Item;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.ItemRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/api/items")
    public ResultResponse getAll() {
        return new SuccessResult<>(itemRepository.findAll().stream().map(Item::getId).toList());
    }

    @PostMapping("/api/items")
    public ResultResponse create(@RequestBody Item item) {
        return new SuccessResult<>(itemRepository.save(item));
    }

    @GetMapping("/api/items/{itemId}")
    public ResultResponse get(@PathVariable Long itemId) {
        Optional<Item> userO = itemRepository.findById(itemId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/items/{itemId}")
    public ResultResponse modify(@RequestBody Item item, @PathVariable Long itemId) {
        Optional<Item> userO = itemRepository.findById(itemId);
        if (userO.isEmpty()) return new FailureResult("Item doesn't exist");
        return new SuccessResult<>(itemRepository.save(item));
    }

    @DeleteMapping("/api/items/{itemId}")
    public ResultResponse delete(@PathVariable Long itemId) {
        Optional<Item> userO = itemRepository.findById(itemId);
        if (userO.isEmpty()) return new FailureResult("Item doesn't exist");
        return new SuccessResult<>(userO.get());
    }

}
