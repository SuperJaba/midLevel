package pl.sda.service;

import org.apache.commons.io.FileUtils;
import pl.sda.model.Adress;
import pl.sda.model.Company;
import pl.sda.model.User;
import pl.sda.xml.XMLFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 */
public class DataService {
private File file;


    public DataService() {
        this.file = new File("C:\\Users\\RENT\\Desktop\\data\\data.dat");
    }

    public void saveData(String xmlString) throws IOException {
        try {
            FileUtils.touch(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtils.writeStringToFile(file, xmlString);

        //stringa zapisac do pliku za pomoca FileUtils.writeStringToFile(file, XMLString);
    }

    public User loadData() {
        User user = null;
        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        String xml;
        try {
             xml = FileUtils.readFileToString(file, "UTF-8");
             user=xmlFactory.xmlToObject(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //pobrac usera z pliku data.dat String xml = FileUtils.readFileToString(file, "UTF-8");
        //przerobic stringXML na Usera
        return user;
    }

    public List<String> printCompanyInfo(Company company) {
        List<String> result = new ArrayList<>();
        result.add(company.getName());
        result.add(company.getAdress().toString());
        result.add(company.getNip());

        return result;
    }

    public void printOut(Company company) {
        List<String> listInfo = printCompanyInfo(company);
        for (String line : listInfo) {
            System.out.println(line);
        }
    }

    public static Properties loadPropertise() {
        Properties result = new Properties();
        InputStream inputStream;
        inputStream = DataService.class.getClassLoader().getResourceAsStream("data.propertis");
        try {
            result.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }



    }
