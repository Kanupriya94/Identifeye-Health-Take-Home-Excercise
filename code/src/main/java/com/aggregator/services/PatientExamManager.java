package com.aggregator.services;

import com.aggregator.models.Exam;
import com.aggregator.models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The PatientExamManager class is responsible for aggregating patients and exams.
 */

public class PatientExamManager {
    private final Map<Integer, Patient> patients;
    private final Map<Integer, Exam> exams;

    private static PatientExamManager instance = null;

    /**
     * Private constructor to ensure singleton pattern
     */
    private PatientExamManager() {
        this.patients = new HashMap<>();
        this.exams = new HashMap<>();
    }

    /**
     * Gets the instance of the PatientExamManager
     *
     * @return the PatientExamManager instance
     */
    public static PatientExamManager getInstance() {
        if (instance == null) {
            instance = new PatientExamManager();
        }
        return instance;
    }

    /**
     * Gets the map of patients
     *
     * @return the map of patients
     */
    public Map<Integer, Patient> getPatients() {
        return patients;
    }

    /**
     * Gets the map of exams
     *
     * @return the map of exams
     */
    public Map<Integer, Exam> getExams() {
        return exams;
    }

    /**
     * Adds a patient with the given id and name
     *
     * @param id   the id of the patient
     * @param name the name of the patient
     */
    public void addPatient(int id, String name) {
        if (!patients.containsKey(id)) {
            patients.put(id, new Patient(id, name));
        }
    }

    /**
     * Adds an exam with the given patient id and exam id
     *
     * @param patientId the id of the patient to add the exam to
     * @param examId    the id of the exam to add
     */
    public void addExam(int patientId, int examId) {
        if (patients.containsKey(patientId) && !exams.containsKey(examId)) {
            exams.put(examId, new Exam(examId, patientId));
            patients.get(patientId).addExam(examId);
        }
    }

    /**
     * Deletes the patient with the given id
     *
     * @param id the id of the patient to delete
     */
    public void deletePatient(int id) {
        if (patients.containsKey(id)) {
            List<Integer> examIds = patients.get(id).getExams();
            for (int examId : examIds) {
                exams.remove(examId);
            }
            patients.remove(id);
        }
    }

    /**
     * Deletes the exam with the given id
     *
     * @param id the id of the exam to delete
     */
    public void deleteExam(int id) {
        if (exams.containsKey(id)) {
            int patientId = exams.get(id).getPatientId();
            patients.get(patientId).removeExam(id);
            exams.remove(id);
        }
    }

    /**
     * Prints a summary of all patients, including name, id, and the number of exams they have taken
     */
    public void printPatientSummary() {
        for (Map.Entry<Integer, Patient> entry : patients.entrySet()) {
            Patient patient = entry.getValue();
            System.out.println("Name: " + patient.getName() + ", Id: " + patient.getId() + ", Exam Count: " + patient.getExams().size());
        }
    }
}
