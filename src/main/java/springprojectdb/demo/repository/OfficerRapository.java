package springprojectdb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springprojectdb.demo.entity.MyOfficers;

public interface OfficerRapository extends JpaRepository<MyOfficers, Integer> {

MyOfficers findBypeopleName(String name);


}
