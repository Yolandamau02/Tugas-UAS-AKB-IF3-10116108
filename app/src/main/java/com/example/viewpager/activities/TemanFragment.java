package com.example.viewpager.activities;

/*
    Tanggal pengerjaan : 07 Agustus 2019
    Nama               : Yolanda Mau
    Nim                : 10116108
    Kelas              : AKB-3
 */



import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.viewpager.R;
import com.example.viewpager.sql.Data;
import com.example.viewpager.sql.DbAdapter;
import com.example.viewpager.sql.DbHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TemanFragment extends Fragment {
    ListView listView;
    private FragmentVP.Presenter presenter;
    private TextView textView;
    List<Data> itemList = new ArrayList<Data>();
    DbAdapter adapter;
    AlertDialog.Builder dialog;
    DbHelper SQLite = new DbHelper(getActivity());

    public static final String TAG_ID = "id";
    public static final String TAG_NIM = "nim";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_KELAS = "kelas";
    public static final String TAG_TELP = "telp";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_INSTAGRAM = "instagram";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragement_teman = inflater.inflate(R.layout.fragment_teman, container, false);

        SQLite = new DbHelper(getActivity().getApplicationContext());

        FloatingActionButton floatingActionButton = (FloatingActionButton) fragement_teman.findViewById(R.id.fab);
        listView = (ListView) fragement_teman.findViewById(R.id.list_view);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FormInput.class);
                startActivity(intent);
            }
        });

        adapter = new DbAdapter(getActivity(), itemList);
        listView.setAdapter(adapter);

        // long press listview to show edit and delete
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                final String idx = itemList.get(position).getId();
                final String nim = itemList.get(position).getNim();
                final String nama = itemList.get(position).getNama();
                final String kelas = itemList.get(position).getKelas();
                final String telp = itemList.get(position).getTelp();
                final String email = itemList.get(position).getEmail();
                final String instagram = itemList.get(position).getInstagram();


                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(getActivity());
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(getActivity(), FormInput.class);
                                intent.putExtra(TAG_ID, idx);
                                intent.putExtra(TAG_NIM, nim);
                                intent.putExtra(TAG_NAMA, nama);
                                intent.putExtra(TAG_KELAS, kelas);
                                intent.putExtra(TAG_TELP, telp);
                                intent.putExtra(TAG_EMAIL, email);
                                intent.putExtra(TAG_INSTAGRAM, instagram);
                                startActivity(intent);
                                break;
                            case 1:
                                SQLite.delete(Integer.parseInt(idx));
                                itemList.clear();
                                getAllData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
        getAllData();
        return fragement_teman;

    }
    public void getAllData(){
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++){
            String id = row.get(i).get(TAG_ID);
            String nim = row.get(i).get(TAG_NIM);
            String nama = row.get(i).get(TAG_NAMA);
            String kelas = row.get(i).get(TAG_KELAS);
            String telp = row.get(i).get(TAG_TELP);
            String email = row.get(i).get(TAG_EMAIL);
            String instagram = row.get(i).get(TAG_INSTAGRAM);

            Data data = new Data();

            data.setId(id);
            data.setNim(nim);
            data.setNama(nama);
            data.setKelas(kelas);
            data.setTelp(telp);
            data.setEmail(email);
            data.setInstagram(instagram);

            itemList.add(data);

        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        itemList.clear();
        getAllData();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.main, menu);
    }
}
