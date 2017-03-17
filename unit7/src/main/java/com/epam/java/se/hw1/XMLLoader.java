package com.epam.java.se.hw1;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLLoader {

    private NodeList setCommands;
    private NodeList getCommands;
    private Map<String, Long> operations = new HashMap<>();
    private Node initialSum;

    public void load(String xmlFileName) {

        try {
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            initialSum = document.getElementsByTagName("initial").item(0);
            setCommands = document.getElementsByTagName("set");
            getCommands = document.getElementsByTagName("get");

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private void addListContentToMap(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                operations.put(element.getNodeName(), Long.valueOf(element.getTextContent()));
            }
        }
    }

    public Map<String, Long> parseOperationsToMap() {
        addListContentToMap(setCommands);
        addListContentToMap(getCommands);
        return operations;
    }

    public Long getInitialSum() {
        return Long.valueOf(initialSum.getTextContent());
    }

    public List<Account> loadTestAccounts() {
        return null;
    }

    public List<Account> loadAccounts() {
        return null;
    }

    public List<Sender> getSenders() {
        return null;
    }
}
