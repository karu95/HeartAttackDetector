package lk.ac.mrt.cse.heartattackdetector.model;

import com.google.firebase.firestore.FirebaseFirestore;

import lk.ac.mrt.cse.heartattackdetector.util.FirebaseConnector;

public class Patient {
    private String patientID;
    private String name;
    private double heartRate;
    private String relatedDoctor;
    private String emergencyContactName;
    private String emergencyContactNo;

    public Patient(String patientID, String name,
                   String emergencyContactName, String emergencyContactNo) {
        this.patientID = patientID;
        this.name = name;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNo = emergencyContactNo;
    }

    public Patient(){}

    public String getPatientID() {
        return patientID;
    }

    public String getName() {
        return name;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNo() {
        return emergencyContactNo;
    }

    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    public String getRelatedDoctor() {
        return relatedDoctor;
    }

    public void setRelatedDoctor(String relatedDoctor) {
        this.relatedDoctor = relatedDoctor;
    }

    public void savePatient() {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();


    }

    public static Patient getPatient(String patientID) {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();
        Patient patient = new Patient();
        return patient;
    }

    public void updatePatient() {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();

    }
}
