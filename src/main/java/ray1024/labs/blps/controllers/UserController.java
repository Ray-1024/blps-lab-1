package ray1024.labs.blps.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ray1024.labs.blps.services.UserService;

@AllArgsConstructor
@RestController("/api/users")
public class UserController {
    private final UserService userService;

}
