package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.User;
import server.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String login) {
        //получили из базы пользователя по логин
        List<User> result = userRepository.findAll();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getLogin().equals(login))
                return result.get(i);
        }
        //User user = new User();
        //user.setLogin(login);
        //user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return null;
    }

}
