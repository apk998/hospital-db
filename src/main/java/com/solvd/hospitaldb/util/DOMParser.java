package com.solvd.hospitaldb.util;

import com.solvd.hospitaldb.Main;
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
    private static final Logger LOGGER= LogManager.getLogger(Main.class);
    public void parseAppointments(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(xmlFilePath));
            Element root = document.getDocumentElement();
            NodeList appointmentList = root.getElementsByTagName("appointment");

            for (int i = 0; i < appointmentList.getLength(); i++) {
                Node appointmentNode = appointmentList.item(i);

                if (appointmentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element appointmentElement = (Element) appointmentNode;

                    String apptId = appointmentElement.getElementsByTagName("appt_id").item(0).getTextContent();
                    String patientId = appointmentElement.getElementsByTagName("patient_id").item(0).getTextContent();
                    String doctorId = appointmentElement.getElementsByTagName("doctor_id").item(0).getTextContent();
                    String apptDate = appointmentElement.getElementsByTagName("appt_date").item(0).getTextContent();

                    LOGGER.info("Appointment ID: " + apptId);
                    LOGGER.info("Patient ID: " + patientId);
                    LOGGER.info("Doctor ID: " + doctorId);
                    LOGGER.info("Appointment Date: " + apptDate);
                }
            }

        } catch (Exception e) {
            LOGGER.info("Error parsing XML file: {}", e.getMessage(), e);
        }
    }
}
