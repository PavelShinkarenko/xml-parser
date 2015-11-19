package ru.task.logic;


import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.task.domain.CD;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class Encoder {
    private Document doc;
    private File file = new File("src/main/webapp/content/catalog.xml");

    public void encode(List<CD> cdList) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(file);
        NodeList nodeList = doc.getElementsByTagName("CD");
        boolean flag = false;
        for (CD cd : cdList) {
            if (nodeList.getLength() > 0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    String title = element.getElementsByTagName("TITLE").item(0).getChildNodes().item(0).getNodeValue();
                    if (cd.getTitle().equals(title)) {
                        rewrite(cd, element);
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    write(cd);
                }
                flag = false;
            } else {
                write(cd);
            }
        }
        transform();
    }

    private void rewrite(CD cd, Element element) {
        element.getElementsByTagName("TITLE").item(0).getChildNodes().item(0).setNodeValue(cd.getTitle());
        element.getElementsByTagName("ARTIST").item(0).getChildNodes().item(0).setNodeValue(cd.getArtist());
        element.getElementsByTagName("COUNTRY").item(0).getChildNodes().item(0).setNodeValue(cd.getCountry());
        element.getElementsByTagName("COMPANY").item(0).getChildNodes().item(0).setNodeValue(cd.getCompany());
        element.getElementsByTagName("PRICE").item(0).getChildNodes().item(0).setNodeValue(cd.getPrice());
        element.getElementsByTagName("YEAR").item(0).getChildNodes().item(0).setNodeValue(cd.getYear());
    }

    private void write(CD cd) {
        Element root = doc.getDocumentElement();

        Element elementCD = doc.createElement("CD");

        Element title = doc.createElement("TITLE");
        title.appendChild(doc.createTextNode(cd.getTitle()));
        elementCD.appendChild(title);

        Element artist = doc.createElement("ARTIST");
        artist.appendChild(doc.createTextNode(cd.getArtist()));
        elementCD.appendChild(artist);

        Element country = doc.createElement("COUNTRY");
        country.appendChild(doc.createTextNode(cd.getCountry()));
        elementCD.appendChild(country);

        Element company = doc.createElement("COMPANY");
        company.appendChild(doc.createTextNode(cd.getCompany()));
        elementCD.appendChild(company);

        Element price = doc.createElement("PRICE");
        price.appendChild(doc.createTextNode(cd.getPrice()));
        elementCD.appendChild(price);

        Element year = doc.createElement("YEAR");
        year.appendChild(doc.createTextNode(cd.getYear()));
        elementCD.appendChild(year);

        root.appendChild(elementCD);

    }

    private void transform() throws TransformerException, FileNotFoundException {
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("src/main/webapp/content/catalog.xml")));
    }

}
