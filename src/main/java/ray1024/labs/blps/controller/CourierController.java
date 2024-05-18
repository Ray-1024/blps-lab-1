package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.Courier;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.CourierRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class CourierController {
    private final CourierRepository courierRepository;

    @PostMapping("/api/users/{userId}/courier")
    public ResultResponse create(@RequestBody Courier courier, @PathVariable Long userId) {
        Optional<Courier> courierO = courierRepository.findByUserId(userId);
        if (courierO.isPresent()) return new FailureResult("Courier already exists");
        return new SuccessResult<>(courierRepository.save(courier));
    }

    @GetMapping("/api/users/{userId}/courier")
    public ResultResponse get(@PathVariable Long userId) {
        Optional<Courier> userO = courierRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/users/{userId}/courier")
    public ResultResponse modify(@RequestBody Courier courier, @PathVariable Long userId) {
        Optional<Courier> userO = courierRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("Courier doesn't exist");
        return new SuccessResult<>(courierRepository.save(courier));
    }

    @DeleteMapping("/api/users/{userId}/courier")
    public ResultResponse delete(@PathVariable Long userId) {
        Optional<Courier> userO = courierRepository.findByUserId(userId);
        if (userO.isEmpty()) return new FailureResult("Courier doesn't exist");
        return new SuccessResult<>(userO.get());
    }
}
