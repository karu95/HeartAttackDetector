package lk.ac.mrt.cse.heartattackdetector.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import lk.ac.mrt.cse.heartattackdetector.util.FirebaseConnector;

public class User {
    private static User user;
    private String username;
    private String password;
    private String userType;
    private String id;

    public User(String username, String password, String userType, String id) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.id = id;
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void saveUser() {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();
        Log.d("INFO", "Firestore created");
        firestore.collection("users").document(username).set(this).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("INFO", "Successfully stored!");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Failure", e.getMessage());
                    }
                });
        Log.d("INFO", "user saved " + username);
    }

    public static User getUser(String username) {
        user = null;
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();
        DocumentReference userRef = firestore.collection("users").document(username);
        if (userRef.get().isComplete()) {
            user = userRef.get().getResult().toObject(User.class);
        }
        return user;
    }

    public boolean updateUser(User user) {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();
        return true;
    }
}