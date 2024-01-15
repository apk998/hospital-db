package com.solvd.hospitaldb.util;

import com.solvd.hospitaldb.bin.Prescription;
import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class JAXBParser {
    File file = new File("src/main/resources/assignment/prescription.xml");

    public static void JAXBUtil {
        try {
            JAXBContext context = JAXBContext.newInstance(Prescription.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Prescription prescription = (Prescription) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException (e);
        }
    }
}
