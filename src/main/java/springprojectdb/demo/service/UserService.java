package springprojectdb.demo.service;

import springprojectdb.demo.models.MyUser;

import java.util.List;
import java.util.Optional;

public interface UserService {

    MyUser get(Integer id);

    MyUser save(MyUser user);

    MyUser update(MyUser user);

    Optional<MyUser> findByLogin(String login);

    Optional<MyUser> findByLoginAndPassword(String login, String password);

    List<MyUser> findAll();


}
