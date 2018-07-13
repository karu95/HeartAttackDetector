package lk.ac.mrt.cse.heartattackdetector.validators;

import lk.ac.mrt.cse.heartattackdetector.model.Patient;

public class PatientValidator {
    public static String validatePatient(Patient patient) {
        String valid = "valid";
        if (patient.getName().isEmpty()) {
            valid = "Please provide name of the patient";
        } else if (patient.getEmergencyContactName().isEmpty()) {
            valid = "Provide emergency contact details";
        } else if (patient.getEmergencyContactNo().isEmpty()) {
            valid = "Provide emergency contact details";
        }
        return valid;
    }
}
