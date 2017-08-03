package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.demo.vo.News;

public class NewsParser {

    private static final String ITEM = "item";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String LINK = "link";
    private static final String PUB_DATE = "pubDate";
    private static final String GUID = "guid";

    private final URL url;

    public NewsParser(String feedUrl) {
        try {
            this.url = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> readNews() throws SAXException, IOException, ParserConfigurationException, ParseException {
        List<News> messages = new ArrayList<News>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(read());

        NodeList nodeList = document.getElementsByTagName(ITEM);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element elem = (Element) node;

            String title = getNodeValue(elem.getElementsByTagName(TITLE).item(0));
            String description = getNodeValue(elem.getElementsByTagName(DESCRIPTION).item(0));
            String link = getNodeValue(elem.getElementsByTagName(LINK).item(0));
            String dateStr = getNodeValue(elem.getElementsByTagName(PUB_DATE).item(0));
            String guid =getNodeValue(elem.getElementsByTagName(GUID).item(0));

            DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
            Date date = formatter.parse(dateStr);

            News message = new News();
            message.setTitle(title);
            message.setDescription(description);
            message.setLink(link);
            message.setDate(date);
            message.setGuid(guid);
            messages.add(message);
        }

        return messages;
    }

    private String getNodeValue(Node node) {
        StringBuilder sb = new StringBuilder("");
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            sb.append(nodeList.item(i).getNodeValue().trim());
        }
        return sb.toString();
    }

    private InputStream read() {
        try {
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}