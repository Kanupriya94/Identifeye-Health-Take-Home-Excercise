package com.aggregator.models;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private final String id;
    private final String name;
    private final List<String> exams;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.exams = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getExams() {
        return exams;
    }

    public void addExam(String examId) {
        exams.add(examId);
    }

    public void removeExam(String examId) {
        exams.remove(examId);
    }
}

