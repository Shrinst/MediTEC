package com.example.aguis.meditecclientapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aguis.meditecclientapp.http.HttpManager;
import com.example.aguis.meditecclientapp.http.RequestPackage;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Profile profile = Profile.getCurrentProfile();
    private Button btnAddAppointment, btnRemoveAppointmnet, btnGetAllAppointment, btnRateDoctor, btnPayment;
    private TextView tvWelcome;
    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (AccessToken.getCurrentAccessToken() == null) {
            goLoginScreen();
        }

        String uri = "http://192.168.43.70:8080/meditecserver/webapi/clientlist/" + profile.getFirstName();
        requestData(uri);

        typeface = Typeface.createFromAsset(getAssets(), "Congratulations_DEMO.ttf");

        btnAddAppointment = (Button) findViewById(R.id.btnAddAppointment);
        btnAddAppointment.setTypeface(typeface);
        btnAddAppointment.setOnClickListener(this);
        btnRemoveAppointmnet = (Button) findViewById(R.id.btnRemoveAppointment);
        btnRemoveAppointmnet.setTypeface(typeface);
        btnRemoveAppointmnet.setOnClickListener(this);
        btnGetAllAppointment = (Button) findViewById(R.id.btnGetAppointment);
        btnGetAllAppointment.setTypeface(typeface);
        btnGetAllAppointment.setOnClickListener(this);
        btnRateDoctor = (Button) findViewById(R.id.btnRateDoctor);
        btnRateDoctor.setTypeface(typeface);
        btnRateDoctor.setOnClickListener(this);
        btnPayment = (Button) findViewById(R.id.btnPay);
        btnPayment.setTypeface(typeface);
        btnPayment.setOnClickListener(this);

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvWelcome.setTypeface(typeface);

        tvWelcome.append(" " + profile.getFirstName());
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void goRegisterScreen() {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    private void requestData(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddAppointment:
                Intent intent = new Intent(MainActivity.this, AddAppointmentActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRateDoctor:
                Intent intentPoint = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(intentPoint);
                break;
            case R.id.btnPay:
                Intent intentPay = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(intentPay);
                break;
            case R.id.btnGetAppointment:
                Intent intentAppointment = new Intent(MainActivity.this, AllAppointmentActivity.class);
                startActivity(intentAppointment);
                break;
            case R.id.btnRemoveAppointment:
                Intent intentCancel = new Intent(MainActivity.this, CancelAppointmentActivity.class);
                startActivity(intentCancel);
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
            content = HttpManager.getData(params[0]);

            return content;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s == null) {
                Toast.makeText(MainActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                JSONObject jsonObject = new JSONObject(s);

                boolean flag = jsonObject.getBoolean("register");

                if (!flag) {
                    goRegisterScreen();
                }

            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, "EX", Toast.LENGTH_SHORT).show();
                //goLoginScreen();
                e.printStackTrace();
            }

            //Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //updateDisplay(values[0]);
        }
    }
}
