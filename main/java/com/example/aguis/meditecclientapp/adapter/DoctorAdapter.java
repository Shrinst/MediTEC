package com.example.aguis.meditecclientapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aguis.meditecclientapp.R;
import com.example.aguis.meditecclientapp.model.Doctor;

import java.util.List;

/**
 * Created by aguis on 18/5/2017.
 */

public class DoctorAdapter extends ArrayAdapter {

    private Context context;
    private List<Doctor> doctorList;
    private Typeface typeface;

    public DoctorAdapter(Context context, int resource, List<Doctor> objects) {
        super(context, resource, objects);
        this.context = context;
        this. doctorList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_doctor, parent, false);

        Doctor doctor =  doctorList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.textViewD);

        tv.setTypeface(typeface);
        tv.append("Nombre: " + doctor.getProfileName() + "\n");
        tv.append("ID: " + doctor.getId() + "\n");
        tv.append("Puntos: " + doctor.getPoints() + "\n");

        return view;
    }
}
