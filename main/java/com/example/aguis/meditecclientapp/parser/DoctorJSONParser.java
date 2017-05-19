package com.example.aguis.meditecclientapp.parser;


import com.example.aguis.meditecclientapp.model.Doctor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aguis on 18/5/2017.
 */

public class DoctorJSONParser {

    public static List<Doctor> parseFeed(String content) {

        try {
            JSONArray jsonArray = new JSONArray(content);
            List<Doctor> appointmentList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Doctor doctor = new Doctor();

                doctor.setProfileName(jsonObject.getString("profileName"));
                doctor.setId(jsonObject.getString("id"));
                doctor.setPoints(jsonObject.getInt("points"));

                appointmentList.add(doctor);
            }

            return appointmentList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
