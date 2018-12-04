package springprojectdb.demo.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojectdb.demo.entity.MyCompany;
import springprojectdb.demo.entity.MyOfficers;
import springprojectdb.demo.scraper.CompanyScraper;
import springprojectdb.demo.scraper.OfficerScraper;
import springprojectdb.demo.service.ScrapService;
import springprojectdb.demo.service.CompanyService;
import springprojectdb.demo.service.OfficerServise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScrapServiceImpl implements ScrapService {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private OfficerServise officerServise;

    @Autowired
    private CompanyScraper companyScraper;

    @Autowired
    private OfficerScraper officerScraper;


    @Override
    public void scrap(String kay) {


        String url1 = "https://beta.companieshouse.gov.uk/company/" + kay;
        Document doc = null;
        try {
            doc = Jsoup.connect(url1).get();
        } catch (IOException e) {
            System.out.println("This page cannot be found");
            return;
        }
        Elements elements3 = doc.getAllElements();
        Optional<MyCompany> optionalUser = companyService.findBycompanyName(elements3.get(0).getElementById("company-name").text());
        MyCompany myCompany = optionalUser.isPresent() ? optionalUser.get() : new MyCompany();


        System.out.println(optionalUser.get());

            final List<MyOfficers> myOfficersList = new ArrayList<>();

            System.out.println("Company  processing kay" + kay);
            companyScraper.scrap(url1, myCompany);
            final MyCompany companyFromDb = companyService.save(myCompany);
            System.out.println("Company  processing success");


            System.out.println("officers processing kay" + kay);
            officerScraper.scrap(url1, myOfficersList);
            myOfficersList.forEach(myOfficers -> {
            myOfficers.setMyCompany(companyFromDb);
            officerServise.save(myOfficers);
            });
            System.out.println("officers processing success");


    }
}
