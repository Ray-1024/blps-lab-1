package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ray1024.labs.blps.service.UserService;

@AllArgsConstructor
@RestController("/api/users")
public class UserController {
    private final UserService userService;

}
