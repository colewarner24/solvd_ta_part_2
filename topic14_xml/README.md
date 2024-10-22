# topic 14 xml and json

[xml, xsd and json file are in resources](https://github.com/colewarner24/solvd_ta_part_2/tree/topic14_xml/jdbc/src/main/resources)

[location for parsers](https://github.com/colewarner24/solvd_ta_part_2/tree/topic14_xml/jdbc/src/main/java/booking/parsers)

# 1. What are the differences between Stax, SAX, DOM? When each parser will be used?
The differences between Stax, SAX, and DOM are as follows:
- Stax is a pull parser, SAX is an event-based parser, and DOM is a tree-based parser.
- Stax is faster than SAX and DOM because it reads the XML file as a stream of events, while SAX reads the XML file as a series of events, and DOM reads the entire XML file into memory.
- Stax is more memory-efficient than SAX and DOM because it only reads the XML file as needed, while SAX reads the entire XML file into memory, and DOM reads the entire XML file into memory.
# 2. What is an XSD schema? How to validate XML using schema?
An XSD schema is a file that defines the structure of an XML document. It specifies the elements, attributes, and data types that are allowed in the XML document.
To validate an XML document using a schema, you can use the javax.xml.validation.SchemaFactory class to create a Schema object from the XSD schema file, and then use the javax.xml.validation.Validator class to validate
# 3. How to represent Array/Date/complex object in XML?
To represent an array in XML, you can use the <array> tag with the <item> tag for each element in the array. For example:
```xml
<array>
    <item>1</item>
    <item>2</item>
    <item>3</item>
</array>
```
To represent a date in XML, you can use the <date> tag with the date value as the content of the tag. For example:
```xml
<date>2022-01-01</date>
```
To represent a complex object in XML, you can use nested tags to represent the properties of the object. For example:
```xml
<complexObject>
    <property1>value1</property1>
    <property2>value2</property2>
</complexObject>
```
# 4. What is attribute? When will you use attribute and when tags?
An attribute is a name-value pair that is associated with an element in an XML document. Attributes are used to provide additional information about an element, such as its id, class, or style.
You should use attributes when the information is metadata about the element, such as its id, class, or style. You should use tags when the information is content that is part of the element, such as the text or other elements.
# 5. How to parse arrays/dates/complex objects usin Jaxb?
To parse arrays, dates, and complex objects using JAXB, you can use the @XmlElement annotation to map the XML elements to Java fields.
# 6. What annotations do you know? Provide the definitions for them?
@XmlRootElement: Specifies the root element of the XML document.
@XmlElement: Specifies the XML element that the field should be mapped to.
@XmlAttribute: Specifies the XML attribute that the field should be mapped to.
@XmlType: Specifies the type of the XML element.
@XmlAccessorType: Specifies the access type for the fields.
# 7. How prevent serialization/desirialization for properties?
To prevent serialization/deserialization for properties, you can use the @XmlTransient annotation to exclude the property from the XML output. For example:
```java
@XmlTransient
private String property;
```
# 8. How to parse arrays/dates/complex objects usin Jackson?
To parse arrays, dates, and complex objects using Jackson, you can use the @JsonProperty annotation to map the JSON properties to Java fields.
# 9. What annotations do you know? Provide the diffinitions for them?
Some of the annotations provided by Jackson are:
- @JsonProperty: Specifies the name of the JSON property that the field should be mapped to.
- @JsonFormat: Specifies the format of the date or number field.
- @JsonIgnore: Excludes the field from the JSON output.
- @JsonInclude: Specifies when the field should be included in the JSON output.
- @JsonCreator: Specifies a constructor to use when deserializing the JSON object.
- @JsonSetter: Specifies a method to use when setting the field value during deserialization.
