package HospitalMS;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import HospitalMS.Doctors;


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
            System.out.println("8. View Doctor's Patient History");
            System.out.println("9. Exit");
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
                    viewDoctorPatientHistory();
                    break;
                case 9:
                    exit = true;
                    System.out.println("Exiting Hospital Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

    private static void addDoctor() {
        String name;
        while (true) {
            System.out.print("Enter Doctor's Full Name (First Name and Surname): ");
            name = scanner.nextLine();
            if (name.trim().split("\\s+").length >= 2) { // Ensure at least two words
                break;
            } else {
                System.out.println("Invalid input. Please enter both a first name and a surname.");
            }
        }

        int age;
        while (true) {
            System.out.print("Enter Doctor's Age: ");
            try {
                age = scanner.nextInt();
                if (age <= 0) {
                    System.out.println("Age must be a positive number. Please try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for the age.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character after age input

        String gender;
        while (true) {
            System.out.print("Enter Doctor's Gender (Male/Female): ");
            gender = scanner.nextLine().trim();
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                break;
            } else {
                System.out.println("Invalid input. Gender must be 'Male' or 'Female'. Please try again.");
            }
        }

        String[] specializations = {
                "General Practitioner",
                "Cardiologist",
                "Pediatrician",
                "Orthopedist",
                "Dermatologist",
                "Neurologist",
                "Psychiatrist"
        };

        System.out.println("Choose Specialization:");
        for (int i = 0; i < specializations.length; i++) {
            System.out.println((i + 1) + ". " + specializations[i]);
        }

        String specialization;
        while (true) {
            System.out.print("Enter the number corresponding to the specialization: ");
            int choice;
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= specializations.length) {
                    specialization = specializations[choice - 1];
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + specializations.length + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character after specialization input

        System.out.print("Enter Doctor ID: ");
        String doctorID = scanner.nextLine();

        Doctors doctor = new Doctors(name, age, gender, specialization, doctorID);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }




    private static void addPatient() {
        String name;
        while (true) {
            System.out.print("Enter Patient's Full Name (First Name and Surname): ");
            name = scanner.nextLine();
            if (name.trim().split("\\s+").length >= 2) { // Ensure at least two words
                break;
            } else {
                System.out.println("Invalid input. Please enter both a first name and a surname.");
            }
        }

        int age;
        while (true) {
            System.out.print("Enter Patient's Age: ");
            try {
                age = scanner.nextInt();
                if (age <= 0) {
                    System.out.println("Age must be a positive number. Please try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for the age.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character after age input

        String gender;
        while (true) {
            System.out.print("Enter Patient's Gender (Male/Female): ");
            gender = scanner.nextLine().trim();
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                break;
            } else {
                System.out.println("Invalid input. Gender must be 'Male' or 'Female'. Please try again.");
            }
        }

        System.out.print("Enter Patient ID: ");
        String patientID = scanner.nextLine();

        // Map of specializations to ailments
        String[][] specializationToAilments = {
                {"General Practitioner", "Cold/Flu", "General Checkup", "Fever", "Headache"},
                {"Cardiologist", "Hypertension", "Heart Disease", "Chest Pain"},
                {"Pediatrician", "Common Cold (Children)", "Vaccination", "Growth Issues"},
                {"Orthopedist", "Bone Fracture", "Arthritis", "Joint Pain"},
                {"Dermatologist", "Skin Allergy", "Eczema", "Acne"},
                {"Neurologist", "Migraine", "Seizures", "Nerve Pain"},
                {"Psychiatrist", "Anxiety", "Depression", "Insomnia"}
        };

        System.out.println("Choose Specialization for the Ailment:");
        for (int i = 0; i < specializationToAilments.length; i++) {
            System.out.println((i + 1) + ". " + specializationToAilments[i][0]);
        }

        String[] ailments = null;
        String selectedSpecialization = "";
        while (ailments == null) {
            try {
                System.out.print("Enter the number corresponding to the specialization: ");
                int specChoice = scanner.nextInt();
                if (specChoice >= 1 && specChoice <= specializationToAilments.length) {
                    ailments = specializationToAilments[specChoice - 1];
                    selectedSpecialization = ailments[0]; // Get the specialization name
                } else {
                    System.out.println("Invalid choice. Please select a valid specialization.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consume newline

        System.out.println("Choose Ailment:");
        for (int i = 1; i < ailments.length; i++) { // Start from 1 to skip specialization name
            System.out.println(i + ". " + ailments[i]);
        }

        String ailment;
        while (true) {
            try {
                System.out.print("Enter the number corresponding to the ailment: ");
                int ailmentChoice = scanner.nextInt();
                if (ailmentChoice >= 1 && ailmentChoice < ailments.length) {
                    ailment = ailments[ailmentChoice];
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a valid ailment.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consume newline

        // Create the patient
        Patient patient = new Patient(name, age, gender, patientID, ailment);
        patients.add(patient);

        // Assign patient to doctors with the matching specialization
        boolean doctorFound = false;
        for (Doctors doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(selectedSpecialization)) {
                doctor.addPatientToHistory(patient);
                doctorFound = true;
            }
        }

        System.out.println("Patient added successfully!");
        if (doctorFound) {
            System.out.println("Patient has been automatically assigned to doctors with specialization: " + selectedSpecialization);
        } else {
            System.out.println("No doctors with the specialization '" + selectedSpecialization + "' found. Patient not assigned to any doctor.");
        }
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
        String name = scanner.nextLine().trim().toLowerCase(); // Trim and convert to lowercase for case-insensitive search

        System.out.println("\nSearching for Doctors:");
        boolean foundDoctor = false;

        for (Doctors doctor : doctors) {
            if (doctor.getName().toLowerCase().contains(name)) { // Use contains for partial match
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
            if (patient.getName().toLowerCase().contains(name)) { // Use contains for partial match
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
