package com.example.swapnil.application1;

import android.Manifest;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;



public class Work extends Fragment implements DatePickerDialog.OnDateSetListener,
        View.OnClickListener,
        TimePickerDialog.OnTimeSetListener{

    TextView date, time, contact;
    TextInputEditText tittle, description;
    Spinner type, before_time;
    Button button;

    int remainder;
    String typeSelected;


    android.support.v4.app.FragmentManager fragmentManager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tittle = (TextInputEditText) view.findViewById(R.id.tittle);
        date = (TextView) view.findViewById(R.id.text_date);
        time = (TextView) view.findViewById(R.id.btn_time);
        description = (TextInputEditText) view.findViewById(R.id.EachDescription);
        type = (Spinner) view.findViewById(R.id.types);
        before_time = (Spinner) view.findViewById(R.id.time_before);
        contact = (TextView) view.findViewById(R.id.contacts);
        button= (Button) view.findViewById(R.id.submit);

        fragmentManager = getActivity().getSupportFragmentManager();

        tittle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                tittle.setText(s.toString().replace(" "," "));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeSelected= type.getSelectedItem().toString();
                // todo pass typeSelected.
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                description.setText(s.toString().replace(" "," "));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        date.setOnClickListener(this);
        time.setOnClickListener(this);
        contact.setOnClickListener(this);
        button.setOnClickListener(this);

        before_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                remainder = Integer.parseInt(before_time.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.add_work, container, false);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_date:
                Calendar now = Calendar.getInstance();
                DatePickerDialog d = DatePickerDialog.newInstance(
                        Work.this,
                        Calendar.YEAR,
                        Calendar.MONTH,
                        Calendar.DAY_OF_MONTH);
                d.show(getActivity().getFragmentManager(), "dd");
                break;
            case R.id.btn_time:
                Calendar tiCalendar = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(Work.this, Calendar.HOUR, Calendar.MINUTE, true);
                tpd.show(getActivity().getFragmentManager(), "time_picker");
            case R.id.contacts:
                PermissionListener permissionlistener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        fragmentManager.beginTransaction().replace(R.id.fragmentHolder, new Contact_picker()).commit();
                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        Toast.makeText(getActivity(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                    }
                };
                new TedPermission(getActivity())
                        .setPermissionListener(permissionlistener)
                        .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                        .setPermissions(Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION)
                        .check();
            case R.id.submit: {
                CreateWork createWork = new CreateWork();
            }
        }
    }

    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH);
        date.setText(month + " " + dayOfMonth + " " + year);
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String secondString = second < 10 ? "0"+second : ""+second;
        time.setText(hourString + ":" + minuteString + ":" + secondString);
    }
}





