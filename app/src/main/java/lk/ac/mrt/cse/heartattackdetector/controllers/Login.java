package lk.ac.mrt.cse.heartattackdetector.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import lk.ac.mrt.cse.heartattackdetector.R;
import lk.ac.mrt.cse.heartattackdetector.model.User;


public class Login extends AppCompatActivity {
    private Button loginButton;
    private Button registerButton;
    private EditText txtUsername;
    private EditText txtPassword;
    private Spinner typeSelector;
    private TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.btnLoginLogin);
        registerButton = (Button) findViewById(R.id.btnLoginRegister);
        txtUsername = (EditText) findViewById(R.id.txtLoginUsername);
        txtPassword = (EditText) findViewById(R.id.txtLoginPassowrd);
        typeSelector = (Spinner) findViewById(R.id.spinnerLoginType);
        txtStatus = (TextView) findViewById(R.id.txtLoginStatus);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void login() {
        String username = txtUsername.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        String userType = typeSelector.getSelectedItem().toString();
        if (!username.isEmpty()) {
            if (!password.isEmpty()) {
                User user = User.getUser(username);
                if (user.getId() == null || user.getId().isEmpty()) {
                    txtStatus.setText("Invalid username/password!");
                } else {

                }
            } else {
                txtStatus.setText("Password Required!");
            }
        } else {
            txtStatus.setText("Please enter your username!");
        }
    }

    private void register() {
        Intent registerIntent = new Intent(getBaseContext(), Register.class);
        startActivity(registerIntent);
    }
}