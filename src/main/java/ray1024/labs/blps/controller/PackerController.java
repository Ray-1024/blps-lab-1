package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.Packer;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.PackerRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class PackerController {
    private final PackerRepository packerRepository;

    @PostMapping("/api/packers")
    public ResultResponse create(@RequestBody Packer packer) {
        Optional<Packer> packerO = packerRepository.findByUserId(packer.getUser().getId());
        if (packerO.isPresent()) return new FailureResult("Packer already exists");
        return new SuccessResult<>(packerRepository.save(packer));
    }

    @GetMapping("/api/packers/{packerId}")
    public ResultResponse get(@PathVariable Long packerId) {
        Optional<Packer> userO = packerRepository.findById(packerId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/packers/{packerId}")
    public ResultResponse modify(@RequestBody Packer packer, @PathVariable Long packerId) {
        Optional<Packer> userO = packerRepository.findById(packerId);
        if (userO.isEmpty()) return new FailureResult("Packer doesn't exist");
        return new SuccessResult<>(packerRepository.save(packer));
    }

    @DeleteMapping("/api/packers/{packerId}")
    public ResultResponse delete(@PathVariable Long packerId) {
        Optional<Packer> userO = packerRepository.findById(packerId);
        if (userO.isEmpty()) return new FailureResult("Packer doesn't exist");
        return new SuccessResult<>(userO.get());
    }
}
