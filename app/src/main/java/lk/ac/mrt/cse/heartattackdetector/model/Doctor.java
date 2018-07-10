package lk.ac.mrt.cse.heartattackdetector.model;

import java.util.HashMap;

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
}
