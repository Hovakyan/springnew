package springprojectdb.demo.scraper;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springprojectdb.demo.entity.MyOfficers;
import springprojectdb.demo.service.OfficerServise;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class OfficerScraper {

    @Autowired
    OfficerServise officerServise;

    public void scrap(String url1, List<MyOfficers> myOfficers,String kay) {

        String url = url1 + "/officers";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("This page cannot be found");
            return;
        }

        Element elcount = doc.getElementById("company-appointments");

        int count = 0;
        try {
            count = Integer.parseInt(elcount.text().substring(0, 1).trim());

        } catch (Error | Exception e) {

        }

        for (int i = 1; i <= count; i++) {

                final MyOfficers myOfficers1 = new MyOfficers();

                try {
                    Element name = doc.getElementById("officer-name-" + i);
                    myOfficers1.setPeople_Name(name.text());

                } catch (Exception e) {
                }
                try {
                    Element adres = doc.getElementById("officer-address-value-" + i);
                    myOfficers1.setPeople__Adres(adres.text());
                } catch (Exception | Error e) {

                }
                try {
                    Element rol = doc.getElementById("officer-role-" + i);
                    myOfficers1.setPeople_Role(rol.text());
                } catch (Error | Exception e) {

                }
                try {

                    Element Occupation = doc.getElementById("officer-occupation-" + i);
                    myOfficers1.setPeople_Occupation(Occupation.text());
                } catch (Error | Exception e) {

                }
                try {
                    Element Country_of_residence = doc.getElementById("officer-country-of-residence-" + i);
                    myOfficers1.setPeople_Country_of_residence(Country_of_residence.text());
                } catch (Exception | Error e) {

                }
                try {
                    Element Nationality = doc.getElementById("officer-nationality-" + i);
                    myOfficers1.setPeople_Nationality(Nationality.text());
                } catch (Error | Exception e) {

                }
                try {

                    Element Appointed_on = doc.getElementById("officer-appointed-on-" + i);
                    myOfficers1.setPeople_Appointed_on(Appointed_on.text());
                } catch (Exception | Error e) {

                }
                try {
                    Element Date_of_birth = doc.getElementById("officer-date-of-birth-" + i);
                    myOfficers1.setPeople_Date_of_birth(Date_of_birth.text());
                } catch (Error | Exception e) {

                }
                myOfficers.add(myOfficers1);

            }
        }
    }

