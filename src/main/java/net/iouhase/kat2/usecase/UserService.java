package net.iouhase.kat2.usecase;

import net.iouhase.kat2.adapters.UserRepository;
import net.iouhase.kat2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByEmail(User user) {
        return userRepository.findById(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public boolean isValidUser(User user) {
        return true;
    }
}
