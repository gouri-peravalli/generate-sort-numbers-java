package com.bally.service;

import com.bally.util.Constant;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
/* This class writes the random numbers to the file */
public class FileWrite {

    public static void writeIntoFile(String fileName, int[] outputValues) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, Constant.MODE_READ_WRITE);
        Arrays.stream(outputValues).forEach(value -> {
            try {
                randomAccessFile.writeBytes(value + "\n");
            } catch (IOException e) {
                System.out.println("IOException Occurred " + e.getMessage());
            }
        });
        randomAccessFile.close();
    }

    /* Method which generates random numbers upto the given limit */
    public static int[] generateRandomUnsortedData(int limit) {
        Random randomValue = new Random();
        return IntStream.generate(() -> randomValue.nextInt(limit))
                .limit(limit)
                .distinct()
                .toArray();
    }
}
