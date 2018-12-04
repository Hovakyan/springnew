package springprojectdb.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojectdb.demo.entity.MyOfficers;
import springprojectdb.demo.repository.OfficerRapository;
import springprojectdb.demo.service.OfficerServise;

import java.util.Optional;

@Service
public class OffiserServiceimpl implements OfficerServise {

    @Autowired
    OfficerRapository officerRapository;

    @Override
    public MyOfficers save(MyOfficers user) {
        return officerRapository.save(user);
    }

    @Override
    public Optional<MyOfficers> findBypeopleName(String name) {
        return Optional.ofNullable(officerRapository.findBypeopleName(name));
    }
}
