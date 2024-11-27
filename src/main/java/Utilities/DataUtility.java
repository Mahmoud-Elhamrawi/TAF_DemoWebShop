package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class DataUtility {



    //TODO:: read data from the json file
    public static final String filePath = "src/test/resources/testData/";
    public static String readJsonFile(String fileName , String key)
    {
        try {
            FileReader fileReader = new FileReader(filePath+fileName+".json");
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            return jsonElement.getAsJsonObject().get(key).getAsString();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  "";
    }

    //TODO:: read data from the property file
    public static String readPropertyFile(String fileName , String propety)
    {
        try {

            Properties properties = new Properties();
            properties.load(new FileInputStream(filePath+fileName+".properties"));
            return properties.getProperty(propety);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }





}
