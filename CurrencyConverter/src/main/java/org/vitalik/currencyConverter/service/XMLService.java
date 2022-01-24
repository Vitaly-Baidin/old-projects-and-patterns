package org.vitalik.currencyConverter.service;

import org.springframework.stereotype.Service;
import org.vitalik.currencyConverter.model.Currency;
import org.vitalik.currencyConverter.model.Rate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    @Override
    public List<Rate> parseRate(String URL) {
        List<Rate> rates = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Valute");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
            LocalDate localDate = LocalDate.parse(doc.getElementsByTagName("ValCurs").item(0).getAttributes().getNamedItem("Date").getNodeValue(), formatter);
            Date date = Date.valueOf(localDate);
            //create an empty list for students
            rates = new ArrayList<>();
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            //loop all available student nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Number number = format.parse(elem.getElementsByTagName("Value").item(0).getTextContent());
                    double value = number.doubleValue();

                    Rate rate = new Rate(date,
                            Integer.parseInt(elem.getElementsByTagName("NumCode").item(0).getTextContent()),
                            value);
                    rates.add(rate);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rates;
    }
}
