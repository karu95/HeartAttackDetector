package lk.ac.mrt.cse.heartattackdetector.util;

import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Created by Mevan on 7/7/2018.
 */

public class FirebaseConnector {
    private static FirebaseConnector firebaseConnector;

    private FirebaseFirestore firestore;

    public static FirebaseConnector getConnector() {
        if (firebaseConnector == null){
            firebaseConnector = new FirebaseConnector();
        }
        return firebaseConnector;
    }

    private FirebaseConnector() {
        firestore = FirebaseFirestore.getInstance();
    }

    public FirebaseFirestore getConnection() {
        return firestore;
    }

}
