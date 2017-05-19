package com.example.aguis.meditecclientapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aguis.meditecclientapp.http.HttpManager;
import com.example.aguis.meditecclientapp.http.RequestPackage;

import org.json.JSONException;
import org.json.JSONObject;

public class CancelAppointmentActivity extends AppCompatActivity implements View.OnClickListener {

    private Typeface typeface;
    private EditText etGetAppointmentId;
    private Button btnSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_appointment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        typeface = Typeface.createFromAsset(getAssets(), "Congratulations_DEMO.ttf");

        etGetAppointmentId = (EditText) findViewById(R.id.etGetAppointmentId);

        btnSendData = (Button) findViewById(R.id.btnSendData);
        btnSendData.setTypeface(typeface);
        btnSendData.setOnClickListener(this);
    }

    private void requestData(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("DELETE");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSendData:
                if (etGetAppointmentId.getText().toString().isEmpty()) {

                    Toast.makeText(CancelAppointmentActivity.this, "Debes agregar el id", Toast.LENGTH_LONG).show();

                } else {

                    requestData("http://192.168.43.70:8080/meditecserver/webapi/appointmentlist/" +
                            etGetAppointmentId.getText().toString());
                    Intent intentMain = new Intent(CancelAppointmentActivity.this, MainActivity.class);
                    startActivity(intentMain);

                }
        }

    }

    private class MyTask extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected void onPreExecute() {
            // updateDisplay("Starting Task");
        }

        @Override
        protected String doInBackground(RequestPackage... params) {

            String content = null;
            content = HttpManager.deleteData(params[0]);

            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(CancelAppointmentActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }

            Toast.makeText(CancelAppointmentActivity.this, "Cita cancelada con éxito", Toast.LENGTH_LONG).show();


            //Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //updateDisplay(values[0]);
        }
    }
}
