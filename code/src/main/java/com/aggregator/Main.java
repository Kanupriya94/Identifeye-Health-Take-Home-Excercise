package com.aggregator;

import java.util.Scanner;
import com.aggregator.services.FileManager;
import com.aggregator.services.PatientExamManager;

/**
 * The Main class is the entry point for the application. It takes the file path as input from the user or uses the
 * default file path and passes it to the FileManager class to read and process the instructions. It then prints the
 * summary of patients and their exams using the PatientExamManager class.
 */
public class Main {

    /**
     * The main method is the entry point for the application.
     *
     * @param args command line arguments, not used
     */
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
