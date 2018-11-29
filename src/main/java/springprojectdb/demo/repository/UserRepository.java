package springprojectdb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springprojectdb.demo.models.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByFirstNameAndLastName(String firstName, String lastName);
    MyUser findByLogin(String login);
    MyUser findByLoginAndPassword(String login, String password);
}
