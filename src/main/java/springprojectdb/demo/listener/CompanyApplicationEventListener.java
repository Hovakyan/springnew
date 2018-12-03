package springprojectdb.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
//import springprojectdb.demo.companyOfficers.Company;
import springprojectdb.demo.companyOfficers.Company;
import springprojectdb.demo.companyOfficers.Officers;
import springprojectdb.demo.entity.MyCompany;
import springprojectdb.demo.service.OfficerServise;
import springprojectdb.demo.service.Companyervice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@Component
public class CompanyApplicationEventListener {
    final MyCompany myCompany = new MyCompany();

    @Autowired
    Companyervice companyervice;

    @Autowired
    OfficerServise officerServise;

    @EventListener({ContextRefreshedEvent.class})
    public void onContextRefreshedEvent() throws FileNotFoundException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/info/info1.txt"));
        Scanner scanner = null;

        try {
            scanner = new Scanner(bufferedReader);
            while (scanner.hasNextLine()) {
                String x = scanner.nextLine();
                Company.companyBackup(x, companyervice);
                Officers.officerBackup(x, officerServise, myCompany);

            }

        } catch (Exception e) {

        }

    }
}
