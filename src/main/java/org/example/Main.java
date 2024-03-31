package org.example;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.io.*;


public class Main {

    public static void main(String[] args) {
        System.out.print("Akopyan Oganes Var 1 RIBO-03-22");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Input files count: ");
            int numFiles = Integer.parseInt(reader.readLine());

            File[] files = new File[numFiles];

            for (int i = 0; i < numFiles; i++) {
                System.out.print("Input file path: " + (i + 1) + ": ");
                String filePath = reader.readLine();
                files[i] = new File(filePath);

                if (!files[i].exists()) {
                    System.out.println("File not found: " + filePath);
                    return;
                }
            }


            String parentDir = files[0].getParent();
            String resultFilePath = parentDir + File.separator + "result.txt";
            File resultFile = new File(resultFilePath);


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
                for (File file : files) {
                    try (BufferedReader readerFromFile = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = readerFromFile.readLine()) != null) {
                            writer.write(line);

                        }
                    }
                }
            }

            System.out.println("SUCCEED. Result file in path: " + resultFilePath);

        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
