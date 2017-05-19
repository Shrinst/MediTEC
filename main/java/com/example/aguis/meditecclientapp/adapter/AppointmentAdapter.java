package com.example.aguis.meditecclientapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aguis.meditecclientapp.R;
import com.example.aguis.meditecclientapp.model.Appointment;

import java.util.List;

/**
 * Created by aguis on 15/5/2017.
 */

public class AppointmentAdapter extends ArrayAdapter<Appointment> {

    private Context context;
    private List<Appointment> appointmentList;
    private Typeface typeface;

    public AppointmentAdapter(Context context, int resource, List<Appointment> objects) {
        super(context, resource, objects);
        this.context = context;
        this.appointmentList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_appointment, parent, false);

        Appointment appointment = appointmentList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.textView);

        tv.setTypeface(typeface);
        tv.append("Nombre: " + appointment.getPatientName() + "\n");
        tv.append("ID del doctor a cargo: " + appointment.getDoctorId() + "\n");
        tv.append("ID de la cita: " + appointment.getId() + "\n");
        tv.append("Fecha: " + appointment.getDate() + "\n");
        tv.append("Lugar: " + appointment.getLocation() + "\n");
        tv.append("Síntomas: " + appointment.getSymptomps() + "\n");

        tv.append("Status: ");

        if (appointment.isIs_Active()) {
            tv.append("Activa" + "\n");
        } else {
            tv.append("Finalizada" + "\n");
        }

        tv.append("Status de pago: ");

        if (appointment.isPay()) {
           tv.append("Cancelado");
        } else {
            tv.append("Pendiente");
        }

        return view;
    }
}
