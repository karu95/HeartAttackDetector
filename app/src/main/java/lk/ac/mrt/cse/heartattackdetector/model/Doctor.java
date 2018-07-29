package lk.ac.mrt.cse.heartattackdetector.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

import lk.ac.mrt.cse.heartattackdetector.util.FirebaseConnector;

public class Doctor {
    private String name;
    private String doctorID;
    private HashMap<String, String> relatedPatients;
    private String contactNo;

    public Doctor(String name, String doctorID, String contactNo) {
        this.doctorID = doctorID;
        this.name = name;
        this.contactNo = contactNo;
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
        firestore.collection("doctors").document(doctorID).set(this).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("INFO", "Doctor successfully stored");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Failure", e.getMessage());
                    }
                });
        ;
    }

    public static Doctor getDoctor(String doctorID) {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();
        DocumentReference doctorRef = firestore.collection("doctors").document(doctorID);
        Doctor doctor = doctorRef.get().getResult().toObject(Doctor.class);
        return doctor;
    }

    public void updateDoctor(Doctor doctor) {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();

    }

    public void setRelatedPatients(HashMap<String, String> relatedPatients) {
        this.relatedPatients = relatedPatients;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
