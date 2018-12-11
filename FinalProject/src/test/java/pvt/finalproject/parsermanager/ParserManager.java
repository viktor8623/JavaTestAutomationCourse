package pvt.finalproject.parsermanager;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pvt.finalproject.model.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ParserManager {

    public List<User> getUsers(String xmlPath) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(xmlPath);
        return new DomParser().parse(document);
    }
}
