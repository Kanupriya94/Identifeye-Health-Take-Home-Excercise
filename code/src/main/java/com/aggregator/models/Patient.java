package com.aggregator.models;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private final int id;
    private final String name;
    private final List<Integer> exams;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
        this.exams = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getExams() {
        return exams;
    }

    public void addExam(int examId) {
        exams.add(examId);
    }

    public void removeExam(int examId) {
        exams.remove(examId);
    }
}

