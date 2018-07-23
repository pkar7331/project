package pl.prz.l6.systempotwierdzaniawizyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prz.l6.systempotwierdzaniawizyt.model.User;
import pl.prz.l6.systempotwierdzaniawizyt.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> loadUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
