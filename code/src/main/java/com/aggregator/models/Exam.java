package com.aggregator.models;

public class Exam {
    private final int id;
    private final int patientId;

    public Exam(int id, int patientId) {
        this.id = id;
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }
}

