package springprojectdb.demo.service.impl;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojectdb.demo.entity.MyCompany;
import springprojectdb.demo.entity.MyOfficers;
import springprojectdb.demo.listener.CompanyApplicationEventListener;
import springprojectdb.demo.scraper.CompanyScraper;
import springprojectdb.demo.scraper.OfficerScraper;
import springprojectdb.demo.service.ScrapService;
import springprojectdb.demo.service.CompanyService;
import springprojectdb.demo.service.OfficerService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Service
public class ScrapServiceImpl implements ScrapService {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private OfficerService officerService;

    @Autowired
    private CompanyScraper companyScraper;

    @Autowired
    private OfficerScraper officerScraper;


    @Override
    public void run() {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("C:/info.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(bufferedReader);
            while (scanner.hasNextLine()) {
                String x = scanner.nextLine();


                String url1 = "https://beta.companieshouse.gov.uk/company/" + x;
                Document doc = null;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    doc = Jsoup.connect(url1).get();
                } catch (IOException e) {
                    System.out.println("This page cannot be found key " + x);
                    break;
                }

                Elements elements = doc.getAllElements();

                if (!companyService.findBycompanyName(elements.get(0).getElementById("company-name").text()).isPresent()) {

                    MyCompany myCompany = new MyCompany();
                    final List<MyOfficers> myOfficersList = new ArrayList<>();
                    System.out.println("Company  processing key " + x);
                    try {
                        companyScraper.scrap(url1, myCompany);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final MyCompany companyFromDb = companyService.save(myCompany);
                    System.out.println("Company  processing success");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("officers processing key " + x);
                    officerScraper.scrap(url1, myOfficersList, x);
                    myOfficersList.forEach(myOfficers -> {
                        myOfficers.setMyCompany(companyFromDb);
                        officerService.save(myOfficers);
                    });
                    System.out.println("officers processing success");

                } else {
                    System.out.println("Company row is repede key = " + x);
                }


            }
        } catch (Exception e) {

        }


    }
}
