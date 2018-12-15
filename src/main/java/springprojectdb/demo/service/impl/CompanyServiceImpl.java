package springprojectdb.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojectdb.demo.entity.MyCompany;
import springprojectdb.demo.repository.CompanyRepository;
import springprojectdb.demo.service.CompanyService;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.isNull;
import static org.springframework.util.Assert.notNull;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;


    @Override
    public MyCompany get(Integer id) {
        notNull(id, "id can not be null");
        companyRepository.getOne(id);
        return null;
    }

    @Override
    public MyCompany save(MyCompany user) {
        notNull(user, "user can not be null");
        return companyRepository.save(user);
    }

    @Override

    public MyCompany saveAndFlush(MyCompany user) {

            return companyRepository.saveAndFlush(user);
        }

    @Override
    public MyCompany update(MyCompany user) {
        notNull(user, "user can not be null");
        return companyRepository.save(user);
    }

    @Override
    public Optional<MyCompany> findBycompanyName(String companyName) {
        hasText(companyName, "login can not be null.");
        return Optional.ofNullable(companyRepository.findBycompanyName(companyName));
    }

    @Override
    public List<MyCompany> findAll() {
        return companyRepository.findAll();
    }
}





