package com.example.swapnil.application1;

import android.content.ContentValues;

public class CreateWork {

    String tittle, description, typeSelected, contact;
    long date, time;
    int remainder, account_id;



    public int addWorkToServer(String tittle, String description, long date, long time, String typeSelected, String contact, int remainder) {
        this.tittle = tittle;
        this.description = description;
        this.date = date;
        this.time = time;
        this.typeSelected = typeSelected;
        this.contact = contact;
        this.remainder = remainder;
        return createWork();
    }

    private int createWork(){
        ContentValues values = new ContentValues();
        values.put("Tittle", tittle);
        values.put("Description", description);
        values.put("Date", date);
        values.put("Time", time);
        values.put("Type", typeSelected);
        values.put("Contact", contact);
        values.put("Remainder", remainder);

//        account_id = (int)
        return 0;
    }


}
