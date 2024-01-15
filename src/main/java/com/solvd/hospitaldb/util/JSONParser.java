package com.solvd.hospitaldb.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.hospitaldb.Main;
import com.solvd.hospitaldb.bin.Surgery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class JSONParser {
    private static final Logger LOGGER= LogManager.getLogger(Main.class);
    private static final String JSON_FILE_PATH = "src/main/resources/assignment/surgery.json";

    public static List<Surgery> readSurgeryData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(JSON_FILE_PATH);
            Surgery[] surgeries = objectMapper.readValue(file, Surgery[].class);
            return Arrays.asList(surgeries);
        } catch (Exception e) {
            LOGGER.info("Could not read data");
            return Collections.emptyList();
        }
    }
}