package springprojectdb.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojectdb.demo.models.MyUser;
import springprojectdb.demo.repository.UserRepository;
import springprojectdb.demo.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public MyUser get(Integer id) {
        notNull(id, "id can not be null");
        userRepository.getOne(id);
        return null;
    }

    @Override
    public MyUser save(MyUser user) {
        notNull(user, "user can not be null");
        return userRepository.save(user);
    }

    @Override
    public MyUser update(MyUser user) {
        notNull(user, "user can not be null");
        return userRepository.save(user);
    }

    @Override
    public Optional<MyUser> findByLogin(String login) {
        hasText(login, "login can not be null.");
        return Optional.ofNullable(userRepository.findByLogin(login));
    }

    @Override
    public Optional<MyUser> findByLoginAndPassword(String login, String password) {
        return Optional.ofNullable(userRepository.findByLoginAndPassword(login, password));
    }

    @Override
    public List<MyUser> findAll() {
        return userRepository.findAll();
    }
}





