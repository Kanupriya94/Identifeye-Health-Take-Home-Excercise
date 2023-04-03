package com.aggregator.models;

/**
 * The Exam class represents an exam that a patient has taken.
 */
public class Exam {

    /**
     * The ID of the exam.
     */
    private final int id;

    /**
     * The ID of the patient who took the exam.
     */
    private final int patientId;

    /**
     * Constructs a new Exam object with the given ID and patient ID.
     *
     * @param id        the ID of the exam
     * @param patientId the ID of the patient who took the exam
     */
    public Exam(int id, int patientId) {
        this.id = id;
        this.patientId = patientId;
    }

    /**
     * @return the ID of the exam
     */
    public int getId() {
        return id;
    }

    /**
     * @return the ID of the patient who took the exam
     */
    public int getPatientId() {
        return patientId;
    }
}
