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
import com.example.aguis.meditecclientapp.model.Appointment;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private Typeface typeface;
    private Button btnPay;
    private EditText etGetCard, etGetID;

    private Appointment appointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        appointment = new Appointment();

        typeface = Typeface.createFromAsset(getAssets(), "Congratulations_DEMO.ttf");

        btnPay = (Button) findViewById(R.id.btnPayAppointment);
        btnPay.setTypeface(typeface);
        btnPay.setOnClickListener(this);

        etGetCard = (EditText) findViewById(R.id.etCard);
        etGetID = (EditText) findViewById(R.id.etIdAppointment);
    }

    private void requestData(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private void requestDataPost(String uri, String[] attributes, String[] values) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("PUT");
        requestPackage.setUri(uri);
        requestPackage.setMessageAttributes(attributes);
        requestPackage.setMessageValues(values);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);

        //Toast.makeText(this, appointment.getDate(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPayAppointment:

                if (etGetID.getText().toString().isEmpty() && etGetCard.getText().toString().isEmpty()) {

                    Toast.makeText(PaymentActivity.this, "Debes llenar todos los espacios", Toast.LENGTH_LONG).show();

                } else {

                    requestData("http://192.168.43.70:8080/meditecserver/webapi/appointmentlist/" + etGetID.getText().toString());
                    Intent intentMain = new Intent(PaymentActivity.this, MainActivity.class);
                    startActivity(intentMain);
                    break;

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

            switch (params[0].getMethod()) {

                case "GET":
                    content = HttpManager.getData(params[0]);
                    break;

                case "PUT":
                    content = HttpManager.putData(params[0]);
                    break;

                default:
                    content = null;
                    break;
            }

            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(PaymentActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                JSONObject jsonObject = new JSONObject(s);

                appointment.setDate(jsonObject.getString("date"));
                appointment.setDoctorId(jsonObject.getString("doctorId"));
                appointment.setId(jsonObject.getInt("id"));
                appointment.setLocation(jsonObject.getString("location"));
                appointment.setPatientName(jsonObject.getString("patientName"));
                appointment.setPay(true);
                appointment.setSymptomps(jsonObject.getString("symptomps"));


            } catch (JSONException e) {

                //goLoginScreen();
                e.printStackTrace();
            }

            String[] attributes = { "patientName", "id", "location", "doctorId", "date", "symptomps", "pay", "is_Active" };
            String[] values = { appointment.getPatientName(), appointment.getId() + "", appointment.getLocation(),
                    appointment.getDoctorId(), appointment.getDate(), appointment.getSymptomps(), appointment.isPay() + "", true + "" };

            requestDataPost("http://192.168.43.70:8080/meditecserver/webapi/appointmentlist/" + etGetID.getText().toString(),
                            attributes, values);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //updateDisplay(values[0]);
        }
    }
}
