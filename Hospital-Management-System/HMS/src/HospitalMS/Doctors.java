package HospitalMS;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;

public class Doctors extends Person {
    private final String specialization;
    private final String doctorID;
    private final List<Patient> patientHistory;

    public Doctors(String name, int age, String gender, String specialization, String doctorID) {
        super(name, age, gender);
        this.specialization = specialization;
        this.doctorID = doctorID;
        this.patientHistory = new ArrayList<>();
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public String getDoctorID() {
        return this.doctorID;
    }

    public void addPatientToHistory(Patient patient) {
        this.patientHistory.add(patient);
    }

    public void displayPatientHistory() {
        System.out.println("Patient History for Doctor: " + this.getName());
        if (this.patientHistory.isEmpty()) {
            System.out.println("No patients treated yet.");
        } else {

            for (Patient patient : this.patientHistory) {
                patient.displayInfo();
                System.out.println();
            }
        }
    }

    public void displayInfo() {
        System.out.println("------ Doctor Details ------");
        super.displayInfo();
        System.out.println("Specialization: " + this.specialization);
        System.out.println("Doctor ID      : " + this.doctorID);
        System.out.println("----------------------------");
    }

}
