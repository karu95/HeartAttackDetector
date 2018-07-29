package lk.ac.mrt.cse.heartattackdetector.util;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

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
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        firestore.setFirestoreSettings(settings);
    }

    public FirebaseFirestore getConnection() {
        return firestore;
    }

}
