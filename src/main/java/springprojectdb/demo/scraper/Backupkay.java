package springprojectdb.demo.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class Backupkay {
    public void info() throws IOException, InterruptedException {
        int x = 0;

        //todo search company by numbers,then you can change by a-Z  (1-90000 to a-Z)
        for (int i = 1; i <= 1; i++) {

        // todo this search by page  ,maximum page 52
            for (int j = 0; j <= 52; j++) {

                try {
                    Document doc = Jsoup.connect("https://beta.companieshouse.gov.uk/search/companies?q=" + i + "&page=" + j).get();
//                    Thread.sleep(5000);
                    System.out.println("search by " + i + "   page " + j);
                    Elements elementsurl = doc.getElementsByAttributeValue("class", "type-company");

                    elementsurl.forEach(elementt -> {
                        Element element9 = elementt.child(0);
                        String url1 = element9.child(0).attr("href");

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //todo kay (01234567) max count = 8
                        if ((url1.substring(url1.lastIndexOf("/") + 1).length() == 8) &&
                                url1.substring(url1.lastIndexOf("/") + 1).charAt(0) != '#') {

                            System.out.println(url1.substring(url1.lastIndexOf("/") + 1));
                            try {
                                // todo all kay  writing in text file ("C:/info/info.txt")
                                FileWriter fileWriter = new FileWriter("C:/info.txt", true);

                                fileWriter.write(url1.substring(url1.lastIndexOf("/") + 1));
                                fileWriter.write("\n");
                                fileWriter.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (Error | Exception e) {
                    System.out.println("Backupkay error");
                }
            }
        }
    }

}