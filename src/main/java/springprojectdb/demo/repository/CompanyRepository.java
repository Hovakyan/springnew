package springprojectdb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springprojectdb.demo.entity.MyCompany;

public interface CompanyRepository extends JpaRepository<MyCompany, Integer> {

    MyCompany findBycompanyName(String companyName);


}
