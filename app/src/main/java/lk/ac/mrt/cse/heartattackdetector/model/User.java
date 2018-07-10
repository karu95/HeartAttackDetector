package lk.ac.mrt.cse.heartattackdetector.model;

import com.google.firebase.firestore.FirebaseFirestore;

import lk.ac.mrt.cse.heartattackdetector.util.FirebaseConnector;

public class User {
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
    }

    public static User getuser(String username) {
        FirebaseFirestore firestore = FirebaseConnector.getConnector().getConnection();
        User user = new User();
        return user;
    }
}
