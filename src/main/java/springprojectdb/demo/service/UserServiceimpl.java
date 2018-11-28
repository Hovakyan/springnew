package springprojectdb.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojectdb.demo.models.User;

import springprojectdb.demo.models.UserLoginPost;
import springprojectdb.demo.repository.UserRepository;
import springprojectdb.demo.service.UserServise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserServise {

    @Autowired
    UserRepository userRepository;
    public UserLoginPost userLoginpost;

    @Override
    public Map<String, User> getUser(User user) {
        Map<String, User> map = new HashMap<>();
        return map;

    }

    @Override
    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }

@Override
    public Optional<User> findByLogin(String login){
        return userRepository.findByLogin(login);
}

@Override
    public Optional<User> findByLoginAndPassword(String login,String password){
        return userRepository.findByLoginAndPassword(login,password);
}

@Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}





