package springprojectdb.demo.listener;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
//import springprojectdb.demo.companyOfficers.Company;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springprojectdb.demo.companyOfficers.Company;
import springprojectdb.demo.companyOfficers.Officers;
import springprojectdb.demo.entity.MyUser;
import springprojectdb.demo.entity.MyUserofficers;
import springprojectdb.demo.repository.UserRepository;
import springprojectdb.demo.service.UserService;
import springprojectdb.demo.service.impl.UserServiceImpl;

import javax.persistence.Column;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CompanyApplicationEventListener {

    @Autowired
    UserService userService;
    @EventListener({ContextRefreshedEvent.class})
    public void onContextRefreshedEvent() throws FileNotFoundException {

    BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/info/info1.txt"));
    Scanner scanner = null;

        try {
            scanner = new Scanner(bufferedReader);
            while (scanner.hasNextLine()) {
                String x = scanner.nextLine();
            Company.companyBackup(x, userService);
            Officers.officerBackup(x, userService);

            }

        } catch (Exception e) {

        }

    }
}
