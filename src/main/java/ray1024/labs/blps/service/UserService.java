package ray1024.labs.blps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.exception.IllegalUserException;
import ray1024.labs.blps.exception.UserAlreadySignedUpException;
import ray1024.labs.blps.exception.UserDoesntExistsException;
import ray1024.labs.blps.exception.UsernameAlreadyUsedException;
import ray1024.labs.blps.model.entity.User;
import ray1024.labs.blps.repository.UserRepository;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User signup(User requestedUser) {
        Optional<User> userO = userRepository.findByUsername(requestedUser.getUsername());
        if (userO.isPresent()) throw new UserAlreadySignedUpException();
        return userRepository.save(requestedUser);
    }

    public User getById(User user) {
        Optional<User> userO = userRepository.findById(user.getId());
        if (!userO.isPresent()) throw new UserDoesntExistsException();
        if (!userO.get().getUsername().equals(user.getUsername())) throw new IllegalUserException();
        return userO.get();
    }

    public User modify(User user) {
        User userOld = getById(user);
        if (!userOld.getUsername().equals(user.getUsername()) && userRepository.findByUsername(user.getUsername()).isPresent())
            throw new UsernameAlreadyUsedException();
        return userRepository.save(user);
    }

    public void takeout(User user) {
        User userOld = getById(user);
        userRepository.delete(userOld);
    }


}
