package springprojectdb.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojectdb.demo.entity.MyUser;
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
    public MyUser saveAndFlush(MyUser user) {
        return userRepository.saveAndFlush(user);
    }




    @Override
    public MyUser update(MyUser user) {
        notNull(user, "user can not be null");
        return userRepository.save(user);
    }

    @Override
    public Optional<MyUser> findBycompanyName(String companyName) {
        hasText(companyName, "login can not be null.");
        return Optional.ofNullable(userRepository.findBycompanyName(companyName));
    }
//
//    @Override
//    public Optional<MyUser> findByLoginAndPassword(String login, String password) {
//        return Optional.ofNullable(userRepository.findByLoginAndPassword(login, password));
//    }



    @Override
    public List<MyUser> findAll() {
        return userRepository.findAll();
    }
}





