package booking.parsers.validator;

import booking.parsers.parser.ParserFacade;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Executor {

    public static void main(String[] args) {
        ParserFacade parserFacade = new ParserFacade();

        for (String className : args) {
            System.out.println("Processing: " + className);

            String xmlPath = "jdbc/src/main/resources/" + className + "/" + className + ".xml";
            String xsdPath = "jdbc/src/main/resources/" + className + "/" + className + ".xsd";
            String jsonPath = "jdbc/src/main/resources/" + className + "/" + className + ".json";

            try {
                // Parse XML if valid
                Object xmlObject = parserFacade.parseXMLIfValid(className, xmlPath, xsdPath);
                if (xmlObject != null) {
                    System.out.println(className + " from XML: " + xmlObject);
                }

                // Parse JSON
                Object jsonObject = parserFacade.parseJSON(jsonPath, className);
                System.out.println(className + " from JSON: " + jsonObject);

            } catch (Exception e) {
                System.err.println("Error processing " + className + ": " + e.getMessage());
            }
        }
    }
}
