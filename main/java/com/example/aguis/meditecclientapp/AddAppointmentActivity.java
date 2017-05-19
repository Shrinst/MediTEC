package com.example.aguis.meditecclientapp;

import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.speech.RecognizerIntent;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aguis.meditecclientapp.http.HttpManager;
import com.example.aguis.meditecclientapp.http.RequestPackage;
import com.facebook.Profile;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class AddAppointmentActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnFindDoctor, btnSymptomps, btnDoctorList, btnSendAppointment;
    private EditText etFindDoctor, etAddDate, etAddPlace;
    private TextView tvDoctorName, tvSymptomps;
    private Typeface typeface;
    private String finalMessageSymptomp = "";
    private Profile profile;

    private int appointmentId;

    private Random rnd;

    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        profile = Profile.getCurrentProfile();

        typeface = Typeface.createFromAsset(getAssets(), "Congratulations_DEMO.ttf");

        appointmentId = 0;

        rnd = new Random();

        btnFindDoctor = (Button) findViewById(R.id.btnFindDoctor);
        btnFindDoctor.setTypeface(typeface);
        btnFindDoctor.setOnClickListener(this);
        btnSymptomps = (Button) findViewById(R.id.btnAddSymptomps);
        btnSymptomps.setTypeface(typeface);
        btnSymptomps.setOnClickListener(this);
        btnDoctorList = (Button) findViewById(R.id.btnSeeDoctors);
        btnDoctorList.setTypeface(typeface);
        btnDoctorList.setOnClickListener(this);
        btnSendAppointment = (Button) findViewById(R.id.btnSendAppointment);
        btnSendAppointment.setTypeface(typeface);
        btnSendAppointment.setOnClickListener(this);

        tvDoctorName = (TextView) findViewById(R.id.tvdoctorInfo);
        tvDoctorName.setTypeface(typeface);
        tvSymptomps = (TextView) findViewById(R.id.tvSymptomps);
        tvSymptomps .setMovementMethod(new ScrollingMovementMethod());
        tvSymptomps.setTypeface(typeface);

        etFindDoctor = (EditText) findViewById(R.id.etFindDoctor);
        etAddDate = (EditText) findViewById(R.id.etaddDate);
        etAddPlace = (EditText) findViewById(R.id.etaddPlace);
    }

    private void requestDataGet(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private void requestDataPost(String uri) {

        this.appointmentId = rnd.nextInt(10000);

        String[] attributes = { "patientName", "id", "location", "doctorId", "date", "symptomps", "pay", "is_Active" };
        String[] values = { profile.getFirstName(), String.valueOf(this.appointmentId), etAddPlace.getText().toString(),
                            etFindDoctor.getText().toString(), etAddDate.getText().toString(), finalMessageSymptomp, false + "",
                            true + "" };

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("POST");
        requestPackage.setUri(uri);
        requestPackage.setMessageAttributes(attributes);
        requestPackage.setMessageValues(values);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendAppointment:
                requestDataPost("http://192.168.43.70:8080/meditecserver/webapi/appointmentlist");
                Intent intentMain = new Intent(AddAppointmentActivity.this, MainActivity.class);
                startActivity(intentMain);
                break;
            case R.id.btnFindDoctor:
                requestDataGet("http://192.168.43.70:8080/meditecserver/webapi/doctorlist/" + etFindDoctor.getText().toString());
                break;
            case R.id.btnSeeDoctors:
                Intent intentDoctorList = new Intent(AddAppointmentActivity.this, AllDoctorActivity.class);
                startActivity(intentDoctorList);
                break;
            case R.id.btnAddSymptomps:
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Diganos sus síntomas, uno a la vez por favor");
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            ArrayList<String> textMatchList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            tvSymptomps.append(textMatchList.get(0) + "\n");
            finalMessageSymptomp += (textMatchList.get(0) + "!");
            Toast.makeText(this, finalMessageSymptomp, Toast.LENGTH_SHORT).show();


            if (!textMatchList.isEmpty()) {
                if (textMatchList.get(0).contains("search")) {
                    String searchQuery = textMatchList.get(0).replace("search", " ");
                    Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
                    search.putExtra(SearchManager.QUERY, searchQuery);
                    startActivity(search);
                }
                else {
                    //  mlvTextMatches.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, textMatchList));
                }
            }
        }
        else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {
            showToastMessage("Audio Error");
        }
        else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
            showToastMessage("Client Error");
        }
        else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {
            showToastMessage("Network Error");
        }
        else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
            showToastMessage("No Match");
        }
        else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {
            showToastMessage("Server Error");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
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

                case "POST":
                    content = HttpManager.postData(params[0]);
                    break;
            }

            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(AddAppointmentActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                JSONObject jsonObject = new JSONObject(s);

                String doctorName = jsonObject.getString("profileName");

                if (doctorName != null) {
                    tvDoctorName.setText("Nombre del doctor: " + doctorName);
                }

            } catch (JSONException e) {
                tvDoctorName.setText("Doctor no encontrado");
                e.printStackTrace();
            }

            //Toast.makeText(AddAppointmentActivity.this, s, Toast.LENGTH_SHORT).show();
            Toast.makeText(AddAppointmentActivity.this, "Cita agregada con éxito", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //updateDisplay(values[0]);
        }
    }
}
