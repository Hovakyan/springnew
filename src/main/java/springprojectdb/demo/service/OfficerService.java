package springprojectdb.demo.service;

import springprojectdb.demo.entity.MyOfficers;

import java.util.Optional;

public interface OfficerService {
    MyOfficers save(MyOfficers user);
    Optional<MyOfficers> findBypeopleName(String name);

}
