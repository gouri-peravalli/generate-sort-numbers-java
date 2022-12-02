package com.bally.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.bally.service.FileWrite.writeIntoFile;
import static com.bally.util.Constant.SORTED_FILE_NAME;
/* This class reads the random numbers from the file and sorts it */
public class FileRead {

    public static void readFromFile(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            int[] intArray = stream.mapToInt(Integer::parseInt).sorted().toArray();
            writeIntoFile(SORTED_FILE_NAME, intArray);
        } catch (IOException e) {
            System.out.println("IOException Occurred " + e.getMessage());
        }
    }
}
