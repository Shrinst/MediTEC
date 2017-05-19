package com.example.aguis.meditecclientapp;

import android.app.ListActivity;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aguis.meditecclientapp.adapter.DoctorAdapter;
import com.example.aguis.meditecclientapp.http.HttpManager;
import com.example.aguis.meditecclientapp.http.RequestPackage;
import com.example.aguis.meditecclientapp.model.Doctor;
import com.example.aguis.meditecclientapp.parser.DoctorJSONParser;

import java.util.List;

public class AllDoctorActivity extends ListActivity {

    List<Doctor> doctorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_doctor);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        requestData("http://192.168.43.70:8080/meditecserver/webapi/doctorlist");
    }

    private void updateDisplay() {

        DoctorAdapter adapter = new DoctorAdapter(this, R.layout.item_doctor, doctorList);
        setListAdapter(adapter);
    }

    private void requestData(String uri) {

        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(uri);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private class MyTask extends AsyncTask<RequestPackage, String, List<Doctor>> {

        @Override
        protected void onPreExecute() {
            // updateDisplay("Starting Task");
        }

        @Override
        protected List<Doctor> doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);
            doctorList = DoctorJSONParser.parseFeed(content);

            return doctorList;
        }

        @Override
        protected void onPostExecute(List<Doctor> s) {

            if (s == null) {
                Toast.makeText(AllDoctorActivity.this, "Can´t connect to webservice", Toast.LENGTH_LONG).show();
                return;
            }

            if (s.isEmpty()) {
                Toast.makeText(AllDoctorActivity.this, "No existen doctores registrados", Toast.LENGTH_SHORT).show();
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
