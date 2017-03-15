import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.model.Adress;
import pl.sda.model.Company;
import pl.sda.model.User;
import pl.sda.service.DataService;

import java.io.IOException;
import java.util.List;

/**
 * Created by RENT on 2017-03-14.
 */
public class DataServiceTest {

    private DataService dataService;
    private String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>\n";
    private User userFromLoad;
    private User userXML;
    private Company company;

    @Before
    public void setUp() {
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");

        company = new Company();
        company.setName("Biedronka");
        company.setNip("12345678");
        company.setAdress(new Adress(Adress.StreetPrefix.STREET ,"3/4", "Cwiartki","60-666", "Poznań","Polska"));
    }

    public void loadData() {
        userFromLoad = dataService.loadData();
    }

    public void saveData() throws IOException {
        dataService.saveData(xmlString);
    }

    @Test
    public void saveAndLoadData() throws IOException {
        saveData();
        loadData();
        Assert.assertTrue(userFromLoad.equals(userXML));
    }

    @Test
    public void printCompanyInfo() {
        List<String> companyInfo = dataService.printCompanyInfo(company);//da nam liste stringow
        System.out.println(companyInfo.toString());
        boolean resultAssert = true;
        resultAssert &= companyInfo.get(0).equals("Biedronka");
        resultAssert &= companyInfo.get(1).equals("ul.Cwiartki 3/4\n60-666 Poznań");
        resultAssert &= companyInfo.get(2).equals("12345678");
        for (String line: companyInfo) {
            System.out.println(line);
        }
        Assert.assertTrue(resultAssert);
    }

}
