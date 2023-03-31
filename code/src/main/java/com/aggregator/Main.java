package com.aggregator;

import com.aggregator.services.FileManager;
import com.aggregator.services.PatientExamManager;

public class Main {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager("/Users/kanupriyaagrawal/workspace/OA/Identifeye-Health-Take-Home-Excercise/input.txt");
        fileManager.processInstructions();
        PatientExamManager.getInstance().printPatientSummary();
    }
}
