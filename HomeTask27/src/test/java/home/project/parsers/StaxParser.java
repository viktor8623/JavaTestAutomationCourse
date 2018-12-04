package home.project.parsers;

import home.project.model.User;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;

public class StaxParser {
    private static final String USER = "User";
    private static final String ID = "id";
    private static final String NAME = "Name";
    private static final String LAST_NAME = "LastName";
    private static final String NICKNAME = "Nickname";
    private static final String BIRTHDAY = "Birthday";
    private User.Builder user;
    List<User> users = new ArrayList<>();

    public List<User> parse(XMLEventReader xmlEventReader) throws XMLStreamException {
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            proceedStartElement(xmlEvent, xmlEventReader);
            proceedEndElement(xmlEvent);
        }
        return users;
    }

    private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
        if (xmlEvent.isStartElement()) {
            StartElement startElement = xmlEvent.asStartElement();
            if (isTagNameEqual(startElement, USER)) {
                user = User.newEntity();
                Attribute attribute = startElement.getAttributeByName(new QName(ID));
                if (attribute != null) {
                    user.withId(Integer.parseInt(attribute.getValue()));
                }
            }
            else if (isTagNameEqual(startElement, NAME)) {
                user.withName(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, LAST_NAME)) {
                user.withLastName(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, NICKNAME)) {
                user.withNickname(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, BIRTHDAY)) {
                user.withBirthday(xmlEventReader.nextEvent().asCharacters().getData());
            }
        }
    }

    private void proceedEndElement(XMLEvent xmlEvent) {
        if (xmlEvent.isEndElement()) {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(USER)) {
                users.add(user.build());
            }
        }
    }

    private boolean isTagNameEqual(StartElement startElement, String tagName) {
        return startElement.getName().getLocalPart().equals(tagName);
    }
}
