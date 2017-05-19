package com.example.aguis.meditecclientapp.parser;

import com.example.aguis.meditecclientapp.model.Appointment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aguis on 7/5/2017.
 */

public class AppointmentJSONParser {

    public static List<Appointment> parseFeed(String content) {

        try {
            JSONArray jsonArray = new JSONArray(content);
            List<Appointment> appointmentList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Appointment appointment = new Appointment();

                appointment.setDate(jsonObject.getString("date"));
                appointment.setDoctorId(jsonObject.getString("doctorId"));
                appointment.setId(jsonObject.getInt("id"));
                appointment.setLocation(jsonObject.getString("location"));
                appointment.setPatientName(jsonObject.getString("patientName"));
                appointment.setPay(jsonObject.getBoolean("pay"));
                appointment.setIs_Active(jsonObject.getBoolean("is_Active"));
                appointment.setSymptomps(jsonObject.getString("symptomps"));

                appointmentList.add(appointment);
            }

            return appointmentList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
