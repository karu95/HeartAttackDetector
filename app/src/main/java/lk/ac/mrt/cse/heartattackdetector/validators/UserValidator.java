package lk.ac.mrt.cse.heartattackdetector.validators;

import lk.ac.mrt.cse.heartattackdetector.model.User;

public class UserValidator {
    public static String validateUser(User user) {
        String valid = "valid";
        if (user.getUsername().isEmpty()) {
            valid = "Username shouldn't be empty!";
        } else if (User.getUser(user.getUsername()) != null) {
            valid = "Username already exists!";
        } else if (!(user.getPassword().length() >= 8 && user.getPassword().length() <= 20)) {
            valid = "Password length should be between 8-20!";
        }
        return valid;
    }
}
