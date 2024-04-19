package ray1024.labs.blps.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
