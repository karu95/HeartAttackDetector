package lk.ac.mrt.cse.heartattackdetector.controllers;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import lk.ac.mrt.cse.heartattackdetector.R;

public class MainPatient extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter bluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_patient);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Thread connectionTester = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (bluetoothAdapter.isEnabled()) {

                    }
                }
            }
        });
    }

    private void bluetoothOn(View view) {
        if (bluetoothAdapter != null) {
            if (!bluetoothAdapter.isEnabled()) {
                Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBTIntent, REQUEST_ENABLE_BT);
            }
        } else {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data) {
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {

            } else if (requestCode == RESULT_CANCELED) {

            }
        }
    }
}
