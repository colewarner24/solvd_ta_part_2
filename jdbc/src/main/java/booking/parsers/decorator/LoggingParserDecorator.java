package booking.parsers.decorator;

import booking.parsers.parser.Parser;
import java.util.logging.Logger;

public class LoggingParserDecorator implements Parser {

    private final Parser parser;
    private static final Logger logger = Logger.getLogger(LoggingParserDecorator.class.getName());

    public LoggingParserDecorator(Parser parser) {
        this.parser = parser;
    }

    @Override
    public Object parse(String path, String className) throws Exception {
        logger.info("Parsing " + className + " from " + path);
        Object result = parser.parse(path, className);
        logger.info("Parsed object: " + result);
        return result;
    }
}

