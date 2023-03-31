package com.aggregator.models;

public class Exam {
    private final String id;
    private final String patientId;

    public Exam(String id, String patientId) {
        this.id = id;
        this.patientId = patientId;
    }

    public String getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }
}

