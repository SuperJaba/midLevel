import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.model.User;
import pl.sda.xml.XMLFactory;

/**
 *
 */
public class XmlFactroyTest extends Exception {

    private String login;
    private String password;
    private String xmlUser;

    @Before
    public void setUp() {
        login = "kowalski";
        password = "abc123";
        xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>\n";
    }

    @Test
    public void objectToXML() {
        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        User user = new User(login, password);
        String xmlUser = xmlFactory.objectToXML(user);
//        System.out.println(xmlUser);
        Assert.assertTrue(user.equals(xmlUser));
    }

    @Test
    public void xmlToObject() {
        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        User userFromXml = xmlFactory.xmlToObject(xmlUser);
        User user = new User(login, password);
//        System.out.println(xmlUser);
        Assert.assertTrue(user.equals(userFromXml));
    }
}
