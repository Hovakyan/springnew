package springprojectdb.demo.service;

import springprojectdb.demo.entity.MyUser;
import springprojectdb.demo.entity.MyUserofficers;

import java.util.List;
import java.util.Optional;

public interface UserService {

    MyUser get(Integer id);

    MyUser save(MyUser user);
    MyUser saveAndFlush(MyUser user);


    MyUser update(MyUser user);

    Optional<MyUser> findBycompanyName(String companyName);

    List<MyUser> findAll();


}
