//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Doctors> doctors = new ArrayList<>();
    private static final List<Patient> patients = new ArrayList<>();
    private static final Scanner scanner;

    public Main() {
    }

    public static void main(String[] args) {
        boolean exit = false;

        while(!exit) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Display Doctors");
            System.out.println("4. Display Patients");
            System.out.println("5. Search by Names");
            System.out.println("6. Delete Doctor");
            System.out.println("7. Delete Patient");
            System.out.println("8. Assign Patient to Doctor");
            System.out.println("9. View Doctor's Patient History");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    displayDoctors();
                    break;
                case 4:
                    displayPatients();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    deleteDoctor();
                    break;
                case 7:
                    deletePatient();
                    break;
                case 8:
                    assignPatientToDoctor();
                    break;
                case 9:
                    viewDoctorPatientHistory();
                    break;
                case 10:
                    exit = true;
                    System.out.println("Exiting Hospital Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

    private static void addDoctor() {
        System.out.print("Enter Doctor's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Doctor's Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor's Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Doctor ID: ");
        String doctorID = scanner.nextLine();
        Doctors doctor = new Doctors(name, age, gender, specialization, doctorID);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void addPatient() {
        System.out.print("Enter Patient's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient's Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient's Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String patientID = scanner.nextLine();
        System.out.print("Enter Ailment: ");
        String ailment = scanner.nextLine();
        Patient patient = new Patient(name, age, gender, patientID, ailment);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    private static void displayDoctors() {
        System.out.println("\nList of Doctors:");
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {

            for (Doctors doctor : doctors) {
                doctor.displayInfo();
                System.out.println();
            }
        }

    }

    private static void displayPatients() {
        System.out.println("\nList of Patients:");
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {

            for (Patient patient : patients) {
                patient.displayInfo();
                System.out.println();
            }
        }

    }

    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        System.out.println("\nSearching for Doctors:");
        boolean foundDoctor = false;

        for (Doctors doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                doctor.displayInfo();
                foundDoctor = true;
                System.out.println();
            }
        }

        if (!foundDoctor) {
            System.out.println("No doctor found with the name: " + name);
        }

        System.out.println("\nSearching for Patients:");
        boolean foundPatient = false;

        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                patient.displayInfo();
                foundPatient = true;
                System.out.println();
            }
        }

        if (!foundPatient) {
            System.out.println("No patient found with the name: " + name);
        }

    }

    private static void deleteDoctor() {
        System.out.print("Enter Doctor ID to delete: ");
        String doctorID = scanner.nextLine();
        Doctors toRemove = null;

        for (Doctors doctor : doctors) {
            if (doctor.getDoctorID().equalsIgnoreCase(doctorID)) {
                toRemove = doctor;
                break;
            }
        }

        if (toRemove != null) {
            doctors.remove(toRemove);
            System.out.println("Doctor deleted successfully!");
        } else {
            System.out.println("No doctor found with the given ID.");
        }

    }

    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        String patientID = scanner.nextLine();
        Patient toRemove = null;

        for (Patient patient : patients) {
            if (patient.getPatientID().equalsIgnoreCase(patientID)) {
                toRemove = patient;
                break;
            }
        }

        if (toRemove != null) {
            patients.remove(toRemove);
            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("No patient found with the given ID.");
        }

    }

    private static void assignPatientToDoctor() {
        System.out.print("Enter Doctor ID: ");
        String doctorID = scanner.nextLine();
        Doctors selectedDoctor = null;

        for (Doctors doctor : doctors) {
            if (doctor.getDoctorID().equalsIgnoreCase(doctorID)) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("No doctor found with the given ID.");
        } else {
            System.out.print("Enter Patient ID: ");
            String patientID = scanner.nextLine();
            Patient selectedPatient = null;

            for (Patient patient : patients) {
                if (patient.getPatientID().equalsIgnoreCase(patientID)) {
                    selectedPatient = patient;
                    break;
                }
            }

            if (selectedPatient == null) {
                System.out.println("No patient found with the given ID.");
            } else {
                selectedDoctor.addPatientToHistory(selectedPatient);
                System.out.println("Patient assigned to Doctor successfully!");
            }
        }
    }

    private static void viewDoctorPatientHistory() {
        System.out.print("Enter Doctor ID: ");
        String doctorID = scanner.nextLine();
        Doctors selectedDoctor = null;

        for (Doctors doctor : doctors) {
            if (doctor.getDoctorID().equalsIgnoreCase(doctorID)) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("No doctor found with the given ID.");
        } else {
            selectedDoctor.displayPatientHistory();
        }
    }

    static {
        scanner = new Scanner(System.in);
    }
}
