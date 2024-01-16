package com.solvd.hospitaldb.util;

import com.solvd.hospitaldb.bin.Appointment;
import com.solvd.hospitaldb.bin.Medication;
import com.solvd.hospitaldb.bin.Prescription;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class JAXBParser {
    private static final Logger LOGGER= LogManager.getLogger(JAXBParser.class);
    private static final String XML_FILE_PATH = "src/main/resources/assignment/prescription.xml";

    public static void JAXBUtil() {
        File file = new File(XML_FILE_PATH);
        try {
            JAXBContext context = JAXBContext.newInstance(Prescription.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Prescription prescription = (Prescription) unmarshaller.unmarshal(file);

            int id = prescription.getId();
            int prescriptionID = prescription.getPrescriptionID();
            Medication medicationID = prescription.getMedicationID();
            String prescriptionDate = prescription.getPrescriptionDate();
            Appointment apptID = prescription.getApptID();

            LOGGER.info("ID: " + id);
            LOGGER.info("Prescription ID: " + prescriptionID);
            LOGGER.info("Medication ID: " + medicationID);
            LOGGER.info("Prescription Date: " + prescriptionDate);
            LOGGER.info("Appointment ID: " + apptID);
        } catch (JAXBException e) {
            throw new RuntimeException (e);
        }
    }
}
