package home.project.parsers;

import home.project.model.User;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxParser extends DefaultHandler {
    private List<User> users;
    private User.Builder user;
    private boolean bName = false;
    private boolean bLastName = false;
    private boolean bNickname = false;
    private boolean bBirthday = false;

    public List<User> getUser() {
        return users;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("User")) {
            String id = attributes.getValue("id");
            user = User.newEntity().withId(Integer.parseInt(id));
            if (users == null) {
                users = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("lastname")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("nickname")) {
            bNickname = true;
        } else if (qName.equalsIgnoreCase("birthday")) {
            bBirthday = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("User")) {
            users.add(user.build());
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {

        if (bName) {
            user.withName(new String(ch, start, length));
            bName = false;
        } else if (bLastName) {
            user.withLastName(new String(ch, start, length));
            bLastName = false;
        } else if (bNickname) {
            user.withNickname(new String(ch, start, length));
            bNickname = false;
        } else if (bBirthday) {
            user.withBirthday(new String(ch, start, length));
            bBirthday = false;
        }
    }
}
