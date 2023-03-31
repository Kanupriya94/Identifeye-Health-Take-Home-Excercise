package com.aggregator.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileManager {
    private final String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

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
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
