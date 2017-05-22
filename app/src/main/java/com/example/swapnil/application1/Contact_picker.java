package com.example.swapnil.application1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Contact_picker extends Fragment {

    ListView contactList;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("inside ","on create view list id ok");

         contactList = (ListView) view.findViewById(R.id.contact_list);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.d("inisde","on create view");
        View view= inflater.inflate(R.layout.fragment_contactlist, container, false);
        contactList= (ListView) view.findViewById(R.id.contact_list);
        getContactAdapeter();

        ContentResolver cr = getActivity().getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null,null);
        while (cursor.moveToNext()){
            //  String contacts = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            // this.contactList.getAdapter();
        }
        cursor.close();
        return view;
    }



    private ArrayAdapter<String> getContactAdapeter() {
        final ArrayList<String> nameCollection = new ArrayList<String>();
        Cursor nameCursor = getActivity().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (nameCursor.moveToNext()){
            String name = nameCursor.getString(nameCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            if (name != null)
                nameCollection.add(name);
        }
        nameCursor.close();
        String[] names = new String[nameCollection.size()];
        nameCollection.toArray();
        Log.d("contact picker:::",":::"+nameCollection.size()+",names size is:::");
        for (int i=0;i<names.length;i++) {
            names[i] = nameCollection.get(i);
            Log.d("name of contace is::", ":::" + names[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line, names);
        contactList.setAdapter(adapter);
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "name is "+nameCollection.get(position), Toast.LENGTH_SHORT).show();
//                String contact = nameCollection.get(position);
            }
        });
        return adapter;
    }

}
