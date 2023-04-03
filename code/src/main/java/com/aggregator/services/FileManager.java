package com.aggregator.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * The FileManager class reads the file of instructions and performs the corresponding actions on the PatientExamManager.
 */
public class FileManager {
    /**
     * The path to the file to be read.
     */
    private final String filePath;

    /**
     * Constructs a new FileManager object with the given file path.
     *
     * @param filePath the path to the file to be read
     */
    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the file of instructions and performs the corresponding actions on the PatientExamManager.
     */
    public void processInstructions() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] sentence = line.split(" ");
                if (sentence[0].equals("ADD") && sentence[1].equals("PATIENT")) {
                    int id = Integer.parseInt(sentence[2]);
                    String name = String.join(" ", Arrays.copyOfRange(sentence, 3, sentence.length));
                    PatientExamManager.getInstance().addPatient(id, name);
                } else if (sentence[0].equals("ADD") && sentence[1].equals("EXAM")) {
                    int patientId = Integer.parseInt(sentence[2]);
                    int examId = Integer.parseInt(sentence[3]);
                    PatientExamManager.getInstance().addExam(patientId, examId);
                } else if (sentence[0].equals("DEL") && sentence[1].equals("PATIENT")) {
                    int id = Integer.parseInt(sentence[2]);
                    PatientExamManager.getInstance().deletePatient(id);
                } else if (sentence[0].equals("DEL") && sentence[1].equals("EXAM")) {
                    int id = Integer.parseInt(sentence[2]);
                    PatientExamManager.getInstance().deleteExam(id);
                }
            }
        } catch (IOException e) {
            System.out.println("An error has been occurred while reading the given file: " + e.getMessage() + " Please enter valid file path");
        }
    }
}
