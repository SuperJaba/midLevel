import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.model.User;
import pl.sda.service.DataService;

import java.io.IOException;

/**
 * Created by RENT on 2017-03-14.
 */
public class DataServiceTest {

    private DataService dataService;
    private String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>\n";
    private User userFromLoad;
    private User userXML;

    @Before
    public void setUp() {
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");
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

}
