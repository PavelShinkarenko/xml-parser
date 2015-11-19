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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Decoder {

    public List<CD> decode(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        NodeList nodeList = doc.getElementsByTagName("CD");
        List<CD> cdList = new ArrayList<CD>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String title = element.getElementsByTagName("TITLE").item(0).getChildNodes().item(0).getNodeValue();
            String artist = element.getElementsByTagName("ARTIST").item(0).getChildNodes().item(0).getNodeValue();
            String country = element.getElementsByTagName("COUNTRY").item(0).getChildNodes().item(0).getNodeValue();
            String company = element.getElementsByTagName("COMPANY").item(0).getChildNodes().item(0).getNodeValue();
            String price = element.getElementsByTagName("PRICE").item(0).getChildNodes().item(0).getNodeValue();
            String year = element.getElementsByTagName("YEAR").item(0).getChildNodes().item(0).getNodeValue();
            cdList.add(new CD(title, artist, country, company, price, year));
        }
        return cdList;
    }


}
