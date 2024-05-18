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

    @PostMapping("/api/couriers")
    public ResultResponse create(@RequestBody Courier courier) {
        Optional<Courier> courierO = courierRepository.findByUserId(courier.getUser().getId());
        if (courierO.isPresent()) return new FailureResult("Courier already exists");
        return new SuccessResult<>(courierRepository.save(courier));
    }

    @GetMapping("/api/couriers/{courierId}")
    public ResultResponse get(@PathVariable Long courierId) {
        Optional<Courier> userO = courierRepository.findById(courierId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/couriers/{courierId}")
    public ResultResponse modify(@RequestBody Courier courier, @PathVariable Long courierId) {
        Optional<Courier> userO = courierRepository.findById(courierId);
        if (userO.isEmpty()) return new FailureResult("Courier doesn't exist");
        return new SuccessResult<>(courierRepository.save(courier));
    }

    @DeleteMapping("/api/couriers/{courierId}")
    public ResultResponse delete(@PathVariable Long courierId) {
        Optional<Courier> userO = courierRepository.findById(courierId);
        if (userO.isEmpty()) return new FailureResult("Courier doesn't exist");
        return new SuccessResult<>(userO.get());
    }


}
