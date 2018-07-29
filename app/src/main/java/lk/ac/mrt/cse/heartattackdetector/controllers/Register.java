package lk.ac.mrt.cse.heartattackdetector.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import lk.ac.mrt.cse.heartattackdetector.R;
import lk.ac.mrt.cse.heartattackdetector.model.User;
import lk.ac.mrt.cse.heartattackdetector.util.IDGenerator;
import lk.ac.mrt.cse.heartattackdetector.validators.UserValidator;

public class Register extends AppCompatActivity {
    private Button btnNext;
    private Button btnLogin;
    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtCnfmPswrd;
    private Spinner typeSelctor;
    private TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnLogin = (Button) findViewById(R.id.btnRegisterLogin);
        btnNext = (Button) findViewById(R.id.btnRegisterNext);
        txtUsername = (EditText) findViewById(R.id.txtRegisterUsername);
        txtPassword = (EditText) findViewById(R.id.txtRegisterPassword);
        txtCnfmPswrd = (EditText) findViewById(R.id.txtRegisterCnfmPswrd);
        txtStatus = (TextView) findViewById(R.id.txtRegisterStatus);
        typeSelctor = (Spinner) findViewById(R.id.spinnerRegisterType);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });
    }

    private void next() {
        String username = txtUsername.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        String cnfmPassword = txtCnfmPswrd.getText().toString().trim();
        String userType = typeSelctor.getSelectedItem().toString().trim();
        Log.d("INFO", "next pressed, data received");
        if (password.equals(cnfmPassword)) {
            String id;
            if (userType.equals("Doctor")) {
                id = IDGenerator.generateDoctorID();
            } else {
                id = IDGenerator.generatePatientID();
            }
            User user = new User(username, password, userType, id);
            String validity = UserValidator.validateUser(user);
            if (validity.equals("valid")) {
                user.saveUser();
                Intent nextStep = null;
                if (userType.equals("Doctor")) {
                    nextStep = new Intent(this, DoctorRegister.class);
                } else {
                    nextStep = new Intent(this, PatientRegister.class);
                }
                nextStep.putExtra("userID", id);
                startActivity(nextStep);
            } else {
                txtStatus.setText(validity);
            }
        } else {
            txtStatus.setText("Password doesn't match!");
        }
    }

    private void login() {
        Intent loginIntent = new Intent(this, Login.class);
        startActivity(loginIntent);
    }
}
