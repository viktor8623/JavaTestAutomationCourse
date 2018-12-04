package home.project.runner;

import home.project.model.User;
import home.project.parsers.DomParser;
import home.project.parsers.SaxParser;
import home.project.parsers.StaxParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class Run {

    private static final String USERS_XML = "src/main/resources/Users.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException {
        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxParser usersHandler = new SaxParser();
        saxParser.parse(new File(USERS_XML), usersHandler);
        List<User> users = usersHandler.getUser();
        users.forEach(country -> System.out.println(country));

        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(USERS_XML));
        users = new StaxParser().parse(xmlEventReader);
        users.forEach(country -> System.out.println(country));

        System.out.println(" ============================== DOM parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(USERS_XML);
        users = new DomParser().parse(document);
        users.forEach(user -> System.out.println(user));
    }

}
