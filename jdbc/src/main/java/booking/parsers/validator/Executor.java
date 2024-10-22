package booking.parsers.validator;

import booking.model.User;
import booking.parsers.parser.JSONParser;
import booking.parsers.parser.XMLParser;
import com.mysql.cj.xdevapi.JsonParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Executor {

    public static void main(String[] args) {
        for (String class_name : args) {
            System.out.println(class_name);

            String xmlPath = "jdbc/src/main/resources/" + class_name + "/" + class_name + ".xml";
            String xsdPath = "jdbc/src/main/resources/" + class_name + "/" + class_name + ".xsd";
            String jsonPath = "jdbc/src/main/resources/" + class_name + "/" + class_name + ".json";

            //Validate XML
            try {
                if (XMLValidator.ValidateXMLSchema(xsdPath, xmlPath)) {

                    XMLParser xmlParser = new XMLParser();
                    Object obj = xmlParser.parseXML(xmlPath, class_name);
                    System.out.println(class_name + " from xml: " + obj);
                }

                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parseJSON(jsonPath, class_name);
                System.out.println("User json: " + obj);
            } catch (JAXBException e) {
                System.out.println("Exception: " + e.getMessage());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
