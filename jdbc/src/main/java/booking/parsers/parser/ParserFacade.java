package booking.parsers.parser;


import booking.parsers.decorator.LoggingParserDecorator;
import booking.parsers.parser.JSONParser;
import booking.parsers.parser.Parser;
import booking.parsers.parser.XMLParser;
import booking.parsers.validator.XMLValidator;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.logging.Logger;

public class ParserFacade {

    private static final Logger logger = Logger.getLogger(ParserFacade.class.getName());
    private final Parser xmlParser;
    private final Parser jsonParser;

    public ParserFacade() {
        // Wrap parsers with Logging Decorators
        xmlParser = new LoggingParserDecorator(new XMLParser());
        jsonParser = new LoggingParserDecorator(new JSONParser());
    }

    public Object parseXMLIfValid(String className, String xmlPath, String xsdPath) throws Exception {
        if (XMLValidator.ValidateXMLSchema(xsdPath, xmlPath)) {
            return xmlParser.parse(xmlPath, className);
        } else {
            logger.warning("XML validation failed for " + xmlPath);
            return null;
        }
    }

    public Object parseJSON(String jsonPath, String className) throws Exception {
        return jsonParser.parse(jsonPath, className);
    }
}
