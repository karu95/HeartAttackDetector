package lk.ac.mrt.cse.heartattackdetector.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import lk.ac.mrt.cse.heartattackdetector.util.FirebaseConnector;

public class Patient {
    private String patientID;
    private String name;
    private double heartRate;
    private String relatedDoctor;
    private String emergencyContactNo;

    public Patient(String patientID, String name,
                   String emergencyContactNo) {
        this.patientID = patientID;
        this.name = name;
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
        firestore.collection("patients").document(patientID).set(this).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("INFO", "Patient successfully stored");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Failure", e.getMessage());
                    }
                });
    }

    public static Patient getPatient(String patientID) {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();
        DocumentReference patientDoc = firestore.collection("patients").document(patientID);
        Patient patient = patientDoc.get().getResult().toObject(Patient.class);
        return patient;
    }

    public void updatePatient(Patient patient) {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();

    }
}
