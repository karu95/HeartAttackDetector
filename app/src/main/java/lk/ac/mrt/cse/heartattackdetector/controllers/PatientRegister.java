package lk.ac.mrt.cse.heartattackdetector.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lk.ac.mrt.cse.heartattackdetector.R;
import lk.ac.mrt.cse.heartattackdetector.model.Patient;
import lk.ac.mrt.cse.heartattackdetector.validators.PatientValidator;

public class PatientRegister extends AppCompatActivity {
    private Button btnSubmit;
    private Button btnLogin;
    private TextView txtStatus;
    private EditText txtName;
    private EditText txtContactNo;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userID = getIntent().getStringExtra("userID");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);
        btnLogin = (Button) findViewById(R.id.btnPatientRegisterLogin);
        btnSubmit = (Button) findViewById(R.id.btnPatientRegisterSubmit);
        txtName = (EditText) findViewById(R.id.txtPatientregisterName);
        txtContactNo = (EditText) findViewById(R.id.txtPatientRegisterContactNo);
        txtStatus = (TextView) findViewById(R.id.txtPatientRegisterStatus);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void submit() {
        String name = txtName.getText().toString().trim();
        String contactNo = txtContactNo.getText().toString().trim();
        Patient patient = new Patient(userID, name, contactNo);
        String validity = PatientValidator.validatePatient(patient);
        if (validity.equals("valid")) {
            patient.savePatient();
            txtStatus.setText("Patient details successfully submitted.");
        } else {
            txtStatus.setText(validity);
        }
    }

    private void login() {
        Intent loginIntent = new Intent(this, Login.class);
        startActivity(loginIntent);
    }
}
