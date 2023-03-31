package com.aggregator.services;

import com.aggregator.models.Exam;
import com.aggregator.models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientExamManager {
    private final Map<Integer, Patient> patients;
    private final Map<Integer, Exam> exams;

    private static PatientExamManager instance = null;

    private PatientExamManager() {
        this.patients = new HashMap<>();
        this.exams = new HashMap<>();
    }

    public static PatientExamManager getInstance() {
        if (instance == null) {
            instance = new PatientExamManager();
        }
        return instance;
    }

    public void addPatient(int id, String name) {
        if (!patients.containsKey(id)) {
            patients.put(id, new Patient(id, name));
        }
    }

    public void addExam(int patientId, int examId) {
        if (patients.containsKey(patientId) && !exams.containsKey(examId)) {
            exams.put(examId, new Exam(examId, patientId));
            patients.get(patientId).addExam(examId);
        }
    }

    public void deletePatient(int id) {
        if (patients.containsKey(id)) {
            List<Integer> examIds = patients.get(id).getExams();
            for (int examId : examIds) {
                exams.remove(examId);
            }
            patients.remove(id);
        }
    }

    public void deleteExam(int id) {
        if (exams.containsKey(id)) {
            int patientId = exams.get(id).getPatientId();
            patients.get(patientId).removeExam(id);
            exams.remove(id);
        }
    }

    public void printPatientSummary() {
        for (Map.Entry<Integer, Patient> entry : patients.entrySet()) {
            Patient patient = entry.getValue();
            System.out.println("Name: " + patient.getName() + ", Id: " + patient.getId() + ", Exam Count: " + patient.getExams().size());
        }
    }
}

