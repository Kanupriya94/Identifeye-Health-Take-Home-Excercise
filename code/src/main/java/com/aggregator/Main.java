package com.aggregator;

import java.util.Scanner;
import com.aggregator.services.FileManager;
import com.aggregator.services.PatientExamManager;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path or press enter to use default file path:");
        String filePath = scanner.nextLine();
        if (filePath == null || filePath.isEmpty()) {
            filePath = Main.class.getClassLoader().getResource("input.txt").getPath();
        }
        scanner.close();
        FileManager fileManager = new FileManager(filePath);
        fileManager.processInstructions();
        PatientExamManager.getInstance().printPatientSummary();
    }
}
