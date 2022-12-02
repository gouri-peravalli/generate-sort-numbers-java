package com.bally;

import com.bally.util.Constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.bally.service.FileRead.readFromFile;
import static com.bally.service.FileWrite.generateRandomUnsortedData;
import static com.bally.service.FileWrite.writeIntoFile;
import static com.bally.util.Constant.UNSORTED_FILE_NAME;

public class Application {
    public static void main(String[] args) throws IOException {
        long startTimeGenerate = System.currentTimeMillis();;
        int limit = Constant.RANDOM_NUMBERS_LIMIT;
        int maxNumbersBound = Constant.MAX_NUMBERS_BOUND;
        System.out.println("Generating millions of records started");
        writeIntoFile(UNSORTED_FILE_NAME, generateRandomUnsortedData(limit,maxNumbersBound));
        System.out.println("Writing millions of records completed");
        long endTimeGenerate = System.currentTimeMillis();;
        System.out.println("Total time taken to generate the file with random numbers: (in secs) "+((endTimeGenerate - startTimeGenerate)/ 1000F));
        long bytes = Files.size(Paths.get(UNSORTED_FILE_NAME));
        System.out.println("File size (in MB): "+ (bytes/(1024*1024)));

        long startTimeSort = System.currentTimeMillis();;
        System.out.println("Reading and sorting millions of records started");
        readFromFile(UNSORTED_FILE_NAME);
        System.out.println("Reading and sorting millions of records completed");
        long endTimeSort = System.currentTimeMillis();;
        System.out.println("Total time taken to sort the file which has random numbers: (in secs)"+((endTimeSort - startTimeSort)/ 1000F));

    }
}
