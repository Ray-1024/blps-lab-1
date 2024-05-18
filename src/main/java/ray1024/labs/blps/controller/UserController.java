package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.model.entity.User;
import ray1024.labs.blps.model.responce.FailureResult;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResult;
import ray1024.labs.blps.repository.UserRepository;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/api/users")
    public ResultResponse create(@RequestBody User user) {
        Optional<User> userO = userRepository.findByUsername(user.getUsername());
        if (userO.isPresent()) return new FailureResult("User already signed up");
        return new SuccessResult<>(userRepository.save(user));
    }

    @GetMapping("/api/users/{userId}")
    public ResultResponse get(@PathVariable Long userId) {
        Optional<User> userO = userRepository.findById(userId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }

    @PutMapping("/api/users/{userId}")
    public ResultResponse modify(@RequestBody User user, @PathVariable Long userId) {
        Optional<User> userO = userRepository.findById(userId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userRepository.save(user));
    }

    @DeleteMapping("/api/users/{userId}")
    public ResultResponse delete(@PathVariable Long userId) {
        Optional<User> userO = userRepository.findById(userId);
        if (userO.isEmpty()) return new FailureResult("User doesn't exist");
        return new SuccessResult<>(userO.get());
    }
}
