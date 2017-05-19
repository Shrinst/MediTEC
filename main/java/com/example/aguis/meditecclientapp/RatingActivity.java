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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aguis.meditecclientapp.http.HttpManager;
import com.example.aguis.meditecclientapp.http.RequestPackage;

import org.json.JSONException;
import org.json.JSONObject;

public class RatingActivity extends AppCompatActivity implements View.OnClickListener {

    private Typeface typeface;
    private Button btnSendInfo, btnFindDoctor;
    private RatingBar rtDoctorPoints;
    private EditText etGetDoctorName;
    private TextView tvDoctorName;

    public static String doctorName = "";
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        typeface = Typeface.createFromAsset(getAssets(), "Congratulations_DEMO.ttf");
        points = 0;

        btnFindDoctor = (Button) findViewById(R.id.btnDoctor);
        btnFindDoctor.setTypeface(typeface);
        btnFindDoctor.setOnClickListener(this);
        btnSendInfo = (Button) findViewById(R.id.btnSendInfo);
        btnSendInfo.setTypeface(typeface);
        btnSendInfo.setOnClickListener(this);

        tvDoctorName = (TextView) findViewById(R.id.tvDoctorName);
        tvDoctorName.setTypeface(typeface);

        etGetDoctorName = (EditText) findViewById(R.id.etGetDoctorName);

        rtDoctorPoints = (RatingBar) findViewById(R.id.ratingBarDoctor);

        listenRatingBar();

    }

    private void listenRatingBar() {
        rtDoctorPoints.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        points = (int) rating;
                    }
                }
        );
    }

    private void requestDataGet(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private void requestDataPut(String uri) {

        String hola = tvDoctorName.getText().toString();

        String[] h = hola.split(" ");

        String[] attributes = { "profileName", "id", "points" };
        String[] values = { h[3], etGetDoctorName.getText().toString(), String.valueOf(points)};

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("PUT");
        requestPackage.setUri(uri);
        requestPackage.setMessageAttributes(attributes);
        requestPackage.setMessageValues(values);

        //Toast.makeText(this, split, Toast.LENGTH_SHORT).show();

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnDoctor:
                requestDataGet("http://192.168.43.70:8080/meditecserver/webapi/doctorlist/" + etGetDoctorName.getText().toString());
                break;
            case R.id.btnSendInfo:
                if (!tvDoctorName.getText().toString().isEmpty() && points > 0) {
                    requestDataPut("http://192.168.43.70:8080/meditecserver/webapi/doctorlist/" + etGetDoctorName.getText().toString());
                    Intent intentMain = new Intent(RatingActivity.this, MainActivity.class);
                    startActivity(intentMain);
                } else {
                   Toast.makeText(this, "Debes llenar todos lo requerimientos", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    public static String getDoctorName() {
        return doctorName;
    }

    public static void setDoctorName(String name) {
        doctorName = name;
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
            }

            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(RatingActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                JSONObject jsonObject = new JSONObject(s);

                String doctorName = jsonObject.getString("profileName");

                if (doctorName != null) {
                    tvDoctorName.setText("Nombre del doctor: " + doctorName);
                    RatingActivity.doctorName = doctorName;
                }

            } catch (JSONException e) {
                tvDoctorName.setText("Doctor no encontrado");
                e.printStackTrace();
            }

            //Toast.makeText(RatingActivity.this, s, Toast.LENGTH_SHORT).show();
            Toast.makeText(RatingActivity.this, "Doctor calificado con éxito", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //updateDisplay(values[0]);
        }
    }
}
