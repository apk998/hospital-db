package com.solvd.hospitaldb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParser {
    private static final Logger LOGGER= LogManager.getLogger(DOMParser.class);
    File file = new File("src/main/resources/assignment/payment.xml");

    public void parsePayment() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(file);
            Element root = document.getDocumentElement();
            NodeList paymentList = root.getElementsByTagName("payment");

            for (int i = 0; i < paymentList.getLength(); i++) {
                Node paymentNode = paymentList.item(i);

                if (paymentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element paymentElement = (Element) paymentNode;

                    String id = paymentElement.getElementsByTagName("id").item(0).getTextContent();
                    String paymentId = paymentElement.getElementsByTagName("payment_id").item(0).getTextContent();
                    String patientId = paymentElement.getElementsByTagName("patient_id").item(0).getTextContent();
                    String amount = paymentElement.getElementsByTagName("amount").item(0).getTextContent();
                    String paymentDate = paymentElement.getElementsByTagName("payment_date").item(0).getTextContent();

                    LOGGER.info("ID: " + id);
                    LOGGER.info("Payment ID: " + paymentId);
                    LOGGER.info("Patient ID: " + patientId);
                    LOGGER.info("Amount: " + amount);
                    LOGGER.info("Payment Date: " + paymentDate);
                }
            }

        } catch (Exception e) {
            LOGGER.info("Error parsing XML file: {}", e.getMessage(), e);
        }
    }
}
