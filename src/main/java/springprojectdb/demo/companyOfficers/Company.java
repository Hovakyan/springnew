package springprojectdb.demo.companyOfficers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import springprojectdb.demo.entity.MyUser;
import springprojectdb.demo.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class Company extends MyUser {


    public static void companyBackup(String kay, UserService userService) throws IOException {

        String url = "https://beta.companieshouse.gov.uk/company/" + kay;

        Document doc = Jsoup.connect(url).get();
        Elements elements3 = doc.getAllElements();

        Optional<MyUser> optionalUser = userService.findBycompanyName(elements3.get(0).getElementById("company-name").text());
        MyUser myUser = optionalUser.isPresent() ? optionalUser.get() : new MyUser();


            myUser.setCompanyName(elements3.get(0).getElementById("company-name").text());
            myUser.setCompany_ID(elements3.get(0).getElementById("company-number").text());
            myUser.setCompany_Registeredofficaddress(elements3.get(0).getElementsByAttributeValue("class", "text data").text());
            myUser.setCompany_Status(elements3.get(0).getElementsByAttributeValue("class", "grid-row").get(0).text());
            myUser.setCompany_Type(elements3.get(0).getElementsByAttributeValue("class", "grid-row").get(1).text());
            myUser.setCompany_Accounts(elements3.get(0).getElementsByAttributeValue("class", "grid-row").get(2).text());


            try {
                myUser.setCompany_NatureOf_BusinessSIC(elements3.get(0).getElementById("sic-title").text() + "\t" +
                        elements3.get(0).getElementById("sic0").text());
            } catch (Error | Exception e) {

            }
            try {
                myUser.setPrevious_company_names(elements3.get(1).getElementById("previousNameTable").text());

            } catch (Exception | Error e) {

            }

        userService.save(myUser);
    }


}
