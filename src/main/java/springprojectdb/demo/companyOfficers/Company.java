package springprojectdb.demo.companyOfficers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import springprojectdb.demo.entity.MyCompany;
import springprojectdb.demo.service.Companyervice;

import java.io.IOException;
import java.util.Optional;


public class Company extends MyCompany {


    public static void companyBackup(String kay, Companyervice companyervice) {

        String url = "https://beta.companieshouse.gov.uk/company/" + kay;

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("This page cannot be found");
            return;
        }

        Elements elements3 = doc.getAllElements();

        Optional<MyCompany> optionalUser = companyervice.findBycompanyName(elements3.get(0).getElementById("company-name").text());
        MyCompany myCompany = optionalUser.isPresent() ? optionalUser.get() : new MyCompany();


        myCompany.setCompanyName(elements3.get(0).getElementById("company-name").text());
        myCompany.setCompany_ID(elements3.get(0).getElementById("company-number").text());
        myCompany.setCompany_Registeredofficaddress(elements3.get(0).getElementsByAttributeValue("class", "text data").text());
        myCompany.setCompany_Status(elements3.get(0).getElementsByAttributeValue("class", "grid-row").get(0).text());
        myCompany.setCompany_Type(elements3.get(0).getElementsByAttributeValue("class", "grid-row").get(1).text());
        myCompany.setCompany_Accounts(elements3.get(0).getElementsByAttributeValue("class", "grid-row").get(2).text());


        try {
            myCompany.setCompany_NatureOf_BusinessSIC(elements3.get(0).getElementById("sic-title").text() + "\t" +
                    elements3.get(0).getElementById("sic0").text());
        } catch (Error | Exception e) {

        }
        try {
            myCompany.setCompany_Previous_names(elements3.get(1).getElementById("previousNameTable").text());

        } catch (Exception | Error e) {

        }

        companyervice.save(myCompany);


    }
}
