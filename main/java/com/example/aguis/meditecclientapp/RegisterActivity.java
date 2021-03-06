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
import android.widget.TextView;
import android.widget.Toast;

import com.example.aguis.meditecclientapp.http.HttpManager;
import com.example.aguis.meditecclientapp.http.RequestPackage;
import com.example.aguis.meditecclientapp.mail.MailSend;
import com.facebook.Profile;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import javax.mail.MessagingException;
import javax.mail.Transport;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInfo1, tvInfo2, tvInfo3;
    private Button btnSendMail, btnScanQR;
    private EditText etEnter_eMail;
    private Typeface typeface;
    private Profile profile = Profile.getCurrentProfile();
    private MailSend mailSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mailSend = new MailSend("meditecteam@gmail.com", "AAEVD_Tec2017");

        typeface = Typeface.createFromAsset(getAssets(), "Congratulations_DEMO.ttf");

        tvInfo1 = (TextView) findViewById(R.id.tvInfo1);
        tvInfo1.setTypeface(typeface);
        tvInfo2 = (TextView) findViewById(R.id.tvInfo2);
        tvInfo2.setTypeface(typeface);
        tvInfo3 = (TextView) findViewById(R.id.tvInfo3);
        tvInfo3.setTypeface(typeface);

        btnSendMail = (Button) findViewById(R.id.btnSendMail);
        btnSendMail.setTypeface(typeface);
        btnSendMail.setOnClickListener(this);
        btnScanQR = (Button) findViewById(R.id.btnScanQR);
        btnScanQR.setTypeface(typeface);
        btnScanQR.setOnClickListener(this);

        etEnter_eMail = (EditText) findViewById(R.id.etEnter_eMail);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendMail:
                mailSend.sendMail(etEnter_eMail.getText().toString());
                break;
            case R.id.btnScanQR:
                IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, R.string.cancel_qr_scan, Toast.LENGTH_LONG).show();
            } else {
                requestData1(result.getContents() + "/" + profile.getFirstName());
                requestData2("http://192.168.43.70:8080/meditecserver/webapi/clinicalcaselist");
                //Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                goMainScreen();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void goMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void requestData1(String uri) {

        String[] attributes = { "clientName", "photo", "register" };
        String[] values = { profile.getFirstName(), profile.getProfilePictureUri(200, 200).toString(), "true" };

        Toast.makeText(this, uri, Toast.LENGTH_SHORT);
        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("PUT");
        requestPackage.setUri(uri);
        requestPackage.setMessageAttributes(attributes);
        requestPackage.setMessageValues(values);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
    }

    private void requestData2(String uri) {

        String[] attributes = { "patientName", "medicine", "medicalTest" };
        String[] values = { profile.getFirstName(), "", "" };

        Toast.makeText(this, uri, Toast.LENGTH_SHORT);
        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("POST");
        requestPackage.setUri(uri);
        requestPackage.setMessageAttributes(attributes);
        requestPackage.setMessageValues(values);

        MyTask task = new MyTask();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, requestPackage);
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
                case "PUT":
                    content = HttpManager.putData(params[0]);
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
                Toast.makeText(RegisterActivity.this, "Can't connect to web service", Toast.LENGTH_LONG).show();
                return;
            }

            //Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
            //Toast.makeText(RegisterActivity.this, profile.getProfilePictureUri(200, 200).toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //updateDisplay(values[0]);
        }
    }
}
