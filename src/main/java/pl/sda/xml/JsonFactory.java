package pl.sda.xml;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;
import pl.sda.model.BillItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonFactory {

    private File file;

    public JsonFactory() {
    }

    public void saveData(String jsonString) {
        File file = new File("C:\\Users\\RENT\\IdeaProjects\\middJava\\src\\main\\resources\\ListOfProducts.dat");
//        FileUtils to klasa statyczna biblioteki
//        touch - pusty plik
        try {
            FileUtils.touch(file);

            //        stringa zapisujemy do pliku za pomoca FileUtils.WriteStringToFile

            FileUtils.writeStringToFile(file, jsonString, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String listToJSon(List list) {
        String json = new Gson().toJson(list);
        return json;
    }

    public List loadData() {
          final Type REVIEW_TYPE = new TypeToken<List<BillItem>>() {}.getType();
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<BillItem> billItemList = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
        return billItemList; // prints to screen some values
    }
}

