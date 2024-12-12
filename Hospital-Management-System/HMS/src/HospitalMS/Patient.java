package HospitalMS;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Patient extends Person {
    private String patientID;
    private String ailment;

    public Patient(String name, int age, String gender, String patientID, String ailment) {
        super(name, age, gender);
        this.patientID = patientID;
        this.ailment = ailment;
    }

    public String getPatientID() {
        return this.patientID;
    }

    public void setPatientID(String patientID) {
        if (!patientID.isEmpty()) {
            this.patientID = patientID;
        } else {
            System.out.println("Patient ID cannot be empty.");
        }

    }

    public String getAilment() {
        return this.ailment;
    }

    public void setAilment(String ailment) {
        if (!ailment.isEmpty()) {
            this.ailment = ailment;
        } else {
            System.out.println("Ailment cannot be empty.");
        }

    }

    public void displayInfo() {
        System.out.println("------ Patient Details ------");
        super.displayInfo();
        System.out.println("Patient ID : " + this.patientID);
        System.out.println("Ailment    : " + this.ailment);
        System.out.println("-----------------------------");
    }
}


