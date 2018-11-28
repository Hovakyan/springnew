package springprojectdb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springprojectdb.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

@Override
    User saveAndFlush(User user);

User getUserByLogin(User user);

Optional<User> findByLogin(String login);
Optional<User> findByLoginAndPassword(String login,String password);

List<User> findAll();


}
