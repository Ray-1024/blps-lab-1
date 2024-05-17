package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ray1024.labs.blps.exception.IllegalUserIdException;
import ray1024.labs.blps.model.request.UserRequest;
import ray1024.labs.blps.model.responce.ResultResponse;
import ray1024.labs.blps.model.responce.SuccessResponse;
import ray1024.labs.blps.model.responce.UserResponse;
import ray1024.labs.blps.service.UserService;

@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;

    @PostMapping("/api/users")
    public UserResponse signup(@RequestBody UserRequest authRequest) {
        return new UserResponse(userService.signup(authRequest.getUser()));
    }

    @GetMapping("/api/users/{userId}")
    public UserResponse getUser(@RequestBody UserRequest authRequest, @PathVariable Long userId) {
        if (!authRequest.getUser().getId().equals(userId)) throw new IllegalUserIdException();
        return new UserResponse(userService.getById(authRequest.getUser()));
    }

    @PutMapping("/api/users/{userId}")
    public UserResponse modifyUser(@RequestBody UserRequest authRequest, @PathVariable Long userId) {
        if (!authRequest.getUser().getId().equals(userId)) throw new IllegalUserIdException();
        return new UserResponse(userService.modify(authRequest.getUser()));
    }

    @DeleteMapping("/api/users/{userId}")
    public ResultResponse takeout(@RequestBody UserRequest authRequest, @PathVariable Long userId) {
        if (!authRequest.getUser().getId().equals(userId)) throw new IllegalUserIdException();
        userService.takeout(authRequest.getUser());
        return new SuccessResponse();
    }
}
