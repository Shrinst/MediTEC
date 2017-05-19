package com.example.aguis.meditecclientapp;

import android.app.ListActivity;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.example.aguis.meditecclientapp.adapter.AppointmentAdapter;
import com.example.aguis.meditecclientapp.http.HttpManager;
import com.example.aguis.meditecclientapp.http.RequestPackage;
import com.example.aguis.meditecclientapp.model.Appointment;
import com.example.aguis.meditecclientapp.parser.AppointmentJSONParser;
import com.facebook.Profile;

import java.util.List;

public class AllAppointmentActivity extends ListActivity {

    private List<Appointment> appointmentList;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_appointment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        profile = Profile.getCurrentProfile();

        //requestData("http://192.168.43.70:8080/meditecserver/webapi/appointmentlist?patientName=" + profile.getFirstName());
        //requestData("http://192.168.43.70:8080/meditecserver/webapi/appointmentlist?id=2");
        requestData("http://192.168.43.70:8080/meditecserver/webapi/appointmentlist?patientName=" + profile.getFirstName());
    }

    private void updateDisplay() {

        AppointmentAdapter adapter = new AppointmentAdapter(this, R.layout.item_appointment, appointmentList);
        setListAdapter(adapter);
    }

    private void requestData(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private class MyTask extends AsyncTask<RequestPackage, String, List<Appointment>> {

        @Override
        protected void onPreExecute() {
            // updateDisplay("Starting Task");
        }

        @Override
        protected List<Appointment> doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);
            appointmentList = AppointmentJSONParser.parseFeed(content);

            return appointmentList;
        }

        @Override
        protected void onPostExecute(List<Appointment> s) {

            if (s == null) {
                Toast.makeText(AllAppointmentActivity.this, "Can´t connect to webservice", Toast.LENGTH_LONG).show();
                return;
            }

            if (s.isEmpty()) {
                Toast.makeText(AllAppointmentActivity.this, "Usted no tiene citas", Toast.LENGTH_SHORT).show();
                return;
            }

            updateDisplay();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //updateDisplay(values[0]);
        }
    }
}
