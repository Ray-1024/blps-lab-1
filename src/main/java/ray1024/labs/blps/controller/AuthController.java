package ray1024.labs.blps.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController {
    // @RequestBody AuthRequest userRequest

    @PostMapping("/api/auth/signup")
    public void signup() {
    }

    @DeleteMapping("/api/auth/takeout")
    public void takeout() {
    }

}
