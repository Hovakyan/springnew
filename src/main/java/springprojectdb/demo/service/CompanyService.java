package springprojectdb.demo.service;

import springprojectdb.demo.entity.MyCompany;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    MyCompany get(Integer id);

    MyCompany save(MyCompany user);

    MyCompany saveAndFlush(MyCompany user);



    MyCompany update(MyCompany user);

    Optional<MyCompany> findBycompanyName(String companyName);

    List<MyCompany> findAll();


}
