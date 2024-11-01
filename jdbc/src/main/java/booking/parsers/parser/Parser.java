package booking.parsers.parser;

public interface Parser {
    Object parse(String path, String className) throws Exception;
}
