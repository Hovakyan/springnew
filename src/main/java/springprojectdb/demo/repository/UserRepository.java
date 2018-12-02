package springprojectdb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springprojectdb.demo.entity.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findBycompanyName(String companyName);


}
