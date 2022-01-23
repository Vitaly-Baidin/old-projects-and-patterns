package org.vitalik.currencyConverter.service;

import org.springframework.stereotype.Service;
import org.vitalik.currencyConverter.model.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLService implements IXMLService {

    @Override
    public List<Currency> parseCurrency(String URL) {

        List<Currency> currencies = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Valute");
            //create an empty list for students
            currencies = new ArrayList<>();

            //loop all available student nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Currency currency = new Currency(
                            Integer.parseInt(elem.getElementsByTagName("NumCode").item(0).getTextContent()),
                            elem.getElementsByTagName("CharCode").item(0).getTextContent(),
                            elem.getElementsByTagName("Name").item(0).getTextContent());
                    currencies.add(currency);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return currencies;
    }
}
