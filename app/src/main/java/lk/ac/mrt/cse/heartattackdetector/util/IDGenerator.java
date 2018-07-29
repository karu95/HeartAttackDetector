package lk.ac.mrt.cse.heartattackdetector.util;

public class IDGenerator {
    public static String generateDoctorID() {
        long timestamp = System.currentTimeMillis();
        String id = "d" + String.valueOf(timestamp);
        return id;
    }

    public static String generatePatientID() {
        long timestamp = System.currentTimeMillis();
        String id = "p" + String.valueOf(timestamp);
        return id;
    }
}
