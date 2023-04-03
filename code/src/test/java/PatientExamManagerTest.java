import com.aggregator.models.Exam;
import com.aggregator.models.Patient;
import com.aggregator.services.FileManager;
import com.aggregator.services.PatientExamManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PatientExamManagerTest {

    private PatientExamManager patientExamManager;

    @BeforeEach
    public void setup() {
        patientExamManager = PatientExamManager.getInstance();
    }

    @Test
    public void testProcessInstructions() {
        FileManager fileManager = new FileManager(getClass().getResource("/input.txt").getPath());
        fileManager.processInstructions();

        // Test patient count
        Map<Integer, Patient> patients = patientExamManager.getPatients();
        assertEquals(2, patients.size());

        // Test patient details
        Patient patient1 = patients.get(123);
        assertNotNull(patient1);
        assertEquals("JOHN DOE", patient1.getName());
        assertEquals(0, patient1.getExams().size());

        Patient patient2 = patients.get(789);
        assertNotNull(patient2);
        assertEquals("JANE CROW", patient2.getName());
        assertEquals(2, patient2.getExams().size());

        // Test exam count
        Map<Integer, Exam> exams = patientExamManager.getExams();
        assertEquals(2, exams.size());

        // Test exam details
        Exam exam1 = exams.get(321);
        assertNull(exam1);

        Exam exam2 = exams.get(445);
        assertNotNull(exam2);
        assertEquals(445, exam2.getId());
        assertEquals(789, exam2.getPatientId());

        Exam exam3 = exams.get(554);
        assertNotNull(exam3);
        assertEquals(554, exam3.getId());
        assertEquals(789, exam3.getPatientId());
    }

    @Test
    public void testDeletePatient() {
        // Add a patient and an exam
        patientExamManager.addPatient(123, "JOHN DOE");
        patientExamManager.addExam(123, 444);

        // Delete the patient and check exam is also deleted
        patientExamManager.deletePatient(123);
        assertNull(patientExamManager.getPatients().get(123));
        assertNull(patientExamManager.getExams().get(444));
    }

    @Test
    public void testDeleteExam() {
        // Add a patient and an exam
        patientExamManager.addPatient(123, "JOHN DOE");
        patientExamManager.addExam(123, 444);

        // Delete the exam and check it's removed from the patient's exam list
        patientExamManager.deleteExam(444);
        assertNull(patientExamManager.getExams().get(444));
        assertEquals(0, patientExamManager.getPatients().get(123).getExams().size());
    }
}
