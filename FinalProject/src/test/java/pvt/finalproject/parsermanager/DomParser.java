package pvt.finalproject.parsermanager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pvt.finalproject.model.User;

import java.util.ArrayList;
import java.util.List;

public class DomParser {
    public List<User> parse(Document document) {
        NodeList nodeList = document.getElementsByTagName("User");
        List<User> users = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            users.add(getUser(nodeList.item(i)));
        }
        return users;
    }

    private static User getUser(Node node) {
        Element element = (Element) node;
        User user = User.newEntity()
                .withId(Integer.parseInt(getAttribute("id", element)))
                .withName(getTagValue("Name", element))
                .withLastName(getTagValue("LastName", element))
                .withNickname(getTagValue("Nickname", element))
                .withBirthday(getTagValue("Birthday", element))
                .build();
        return user;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private static String getAttribute(String attributeName, Element element) {
        return element.getAttribute(attributeName);
    }
}
