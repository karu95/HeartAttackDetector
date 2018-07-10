package lk.ac.mrt.cse.heartattackdetector.model;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

import lk.ac.mrt.cse.heartattackdetector.util.FirebaseConnector;

public class Doctor {
    private String name;
    private String doctorID;
    private HashMap<String, String> relatedPatients;

    public Doctor(String name, String doctorID) {
        this.doctorID = doctorID;
        this.name = name;
    }

    public Doctor(){}

    public String getName() {
        return name;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public HashMap<String, String> getRelatedPatients() {
        return relatedPatients;
    }

    public boolean addPatient(Patient patient) {
        boolean inserted = false;
        if (!relatedPatients.containsKey(patient.getPatientID())) {
            relatedPatients.put(patient.getPatientID(), patient.getName());
            inserted = true;
        }
        return inserted;
    }

    public boolean removePatient(Patient patient) {
        boolean removed = false;
        if (relatedPatients.containsKey(patient.getPatientID())){
            relatedPatients.remove(patient.getPatientID());
            removed = true;
        }
        return removed;
    }

    public void saveDoctor() {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();

    }

    public static Doctor getDoctor() {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();
        Doctor doctor = new Doctor();
        return doctor;
    }

    public void updateDoctor() {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();

    }

    public void setRelatedPatients(HashMap<String, String> relatedPatients) {
        this.relatedPatients = relatedPatients;
    }
}
