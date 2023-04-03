package com.aggregator.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The Patient class represents a patient in the system.
 */
public class Patient {

    /**
     * The ID of the patient.
     */
    private final int id;

    /**
     * The name of the patient.
     */
    private final String name;

    /**
     * The list of IDs of the exams that the patient has taken.
     */
    private List<Integer> exams;

    /**
     * Constructs a new Patient object with the given ID and name.
     *
     * @param id   the ID of the patient
     * @param name the name of the patient
     */
    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
        this.exams = new ArrayList<>();
    }

    /**
     * Returns the ID of the patient.
     *
     * @return the ID of the patient
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the patient.
     *
     * @return the name of the patient
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a list of the IDs of the exams that the patient has taken.
     *
     * @return a list of the IDs of the exams that the patient has taken
     */
    public List<Integer> getExams() {
        return exams;
    }

    /**
     * Adds the given exam ID to the list of exams that the patient has taken.
     *
     * @param examId the ID of the exam to add
     */
    public void addExam(int examId) {
        exams.add(examId);
    }

    /**
     * Removes the given exam ID from the list of exams that the patient has taken.
     *
     * @param examId the ID of the exam to remove
     */
    public void removeExam(Integer examId) {
        exams.remove(examId);
    }
}
